package software.ulpgc;

import software.ulpgc.domain.Employee;
import software.ulpgc.io.*;
import software.ulpgc.statistic.GenderFrequencyCalculator;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("--- Iteración 2: URL a Fichero Local ---");

        URL url = new URL("https://raw.githubusercontent.com/sachin365123/CSV-files-for-Data-Science-and-Machine-Learning/refs/heads/main/Employee%20Dataset%20-%20TSV.txt");

        File outputFile = new File("statistics.tsv");

        try (InputStream is = url.openStream();
             OutputStream os = new FileOutputStream(outputFile)) {

            EmployeeLoader loader = StreamEmployeeLoader.with(is, TsvEmployeeDeserializer.create());
            List<Employee> employees = loader.load();

            Map<String, Long> statistics = GenderFrequencyCalculator.calculate(employees);

            StatisticsWriter writer = TsvStatisticsWriter.with(os);
            writer.write(statistics);
        }
    }
}