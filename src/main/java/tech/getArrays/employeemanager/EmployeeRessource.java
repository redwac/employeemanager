package tech.getArrays.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getArrays.employeemanager.model.Employee;
import tech.getArrays.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeRessource {
    private final EmployeeService employeeService;

    public EmployeeRessource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee addEmployee = employeeService.addEmployee(employee);
        return new  ResponseEntity<>(addEmployee,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new  ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @PutMapping("Delete/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
        return new  ResponseEntity<>(HttpStatus.OK);
    }

}
