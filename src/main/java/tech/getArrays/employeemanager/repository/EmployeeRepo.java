package tech.getArrays.employeemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getArrays.employeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
