package software.ulpgc;

import software.ulpgc.domain.Employee;
import software.ulpgc.io.*;
import software.ulpgc.statistic.GenderFrequencyCalculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("--- Iteración 1: Fichero a Consola ---");

        File file = new File("employees.tsv");
        System.out.println("Leyendo archivo en: " + file.getAbsolutePath());

        try (InputStream is = new FileInputStream(file)) {
            EmployeeLoader loader = StreamEmployeeLoader.with(is, TsvEmployeeDeserializer.create());
            List<Employee> employees = loader.load();

            Map<String, Long> statistics = GenderFrequencyCalculator.calculate(employees);

            StatisticsWriter writer = TsvStatisticsWriter.with(System.out);
            writer.write(statistics);
        }
    }
}