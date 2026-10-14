package software.ulpgc;

import software.ulpgc.domain.Employee;
import software.ulpgc.io.*;
import software.ulpgc.statistic.GenderFrequencyCalculator;

import java.io.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("--- Iteración 3: Fichero a Memoria ---");

        File file = new File("employees.tsv");

        try (InputStream is = new FileInputStream(file);
             ByteArrayOutputStream os = new ByteArrayOutputStream()) {

            EmployeeLoader loader = StreamEmployeeLoader.with(is, TsvEmployeeDeserializer.create());
            List<Employee> employees = loader.load();

            Map<String, Long> statistics = GenderFrequencyCalculator.calculate(employees);

            StatisticsWriter writer = TsvStatisticsWriter.with(os);
            writer.write(statistics);

            System.out.println("Resultados guardados en memoria (ByteArrayOutputStream):");
            System.out.println(os.toString());
        }
    }
}