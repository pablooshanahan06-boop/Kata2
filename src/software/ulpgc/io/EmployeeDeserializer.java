package software.ulpgc.io;

import software.ulpgc.domain.Employee;
import java.util.Optional;

public interface EmployeeDeserializer {
    Optional<Employee> deserialize(String line);
}