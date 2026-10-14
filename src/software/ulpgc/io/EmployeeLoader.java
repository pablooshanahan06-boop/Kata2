package software.ulpgc.io;

import software.ulpgc.domain.Employee;
import java.util.List;

public interface EmployeeLoader {
    List<Employee> load();
}