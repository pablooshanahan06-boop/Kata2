package software.ulpgc.io;

import software.ulpgc.domain.Employee;
import software.ulpgc.domain.Gender;
import java.util.Optional;

public class TsvEmployeeDeserializer implements EmployeeDeserializer {
    private static final String DELIMITER = "\t";

    private TsvEmployeeDeserializer() {}

    public static TsvEmployeeDeserializer create() {
        return new TsvEmployeeDeserializer();
    }

    @Override
    public Optional<Employee> deserialize(String line) {
        String[] fields = line.split(DELIMITER);
        if (fields.length < 6) {
            System.err.println("Aviso: Fila con formato inválido -> " + line);
            return Optional.empty();
        }
        try {
            return Optional.of(new Employee(
                    fields[0].trim(),
                    Gender.from(fields[5].trim())
            ));
        } catch (IllegalArgumentException e) {
            System.err.println("Aviso: Dato de género inválido en la fila -> " + line);
            return Optional.empty();
        }
    }
}