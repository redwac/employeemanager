package tech.getArrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getArrays.employeemanager.exception.UserNotFoundException;
import tech.getArrays.employeemanager.model.Employee;
import tech.getArrays.employeemanager.repository.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    //@Autowired
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
       return employeeRepo.findEmployeeById(id)
               .orElseThrow(() -> new UserNotFoundException("user by id" + id + " not found "));
    }
    public void deleteEmployeeById(Long id){
        employeeRepo.deleteEmployeeById(id);


    }
}
