package software.ulpgc.statistic;

import software.ulpgc.domain.Employee;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenderFrequencyCalculator {
    private GenderFrequencyCalculator() {}

    public static Map<String, Long> calculate(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        employee -> employee.gender().name(),
                        Collectors.counting()
                ));
    }
}