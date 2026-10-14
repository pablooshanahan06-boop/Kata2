package software.ulpgc.io;

import software.ulpgc.domain.Employee;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamEmployeeLoader implements EmployeeLoader {
    private final InputStream inputStream;
    private final EmployeeDeserializer deserializer;

    private StreamEmployeeLoader(InputStream inputStream, EmployeeDeserializer deserializer) {
        this.inputStream = inputStream;
        this.deserializer = deserializer;
    }

    public static StreamEmployeeLoader with(InputStream inputStream, EmployeeDeserializer deserializer) {
        return new StreamEmployeeLoader(inputStream, deserializer);
    }

    @Override
    public List<Employee> load() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines()
                    .skip(1)
                    .map(deserializer::deserialize)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Error leyendo el flujo de datos: " + e.getMessage());
            return List.of();
        }
    }
}