package com.org.tcs.controller;
import com.org.tcs.model.Employee;
import com.org.tcs.repository.EmployeeRepo;
import com.org.tcs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }
    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }
    @GetMapping("/getAll")
    public List<Employee>getAll(){
       List<Employee> emp = employeeService.getAll();
        return emp;
    }
    @GetMapping("/getById/{employeeId}")
    public Optional<Employee> getById(@PathVariable Integer employeeId){
        Optional<Employee> e = employeeService.getById(employeeId);
        return e;
    }
    @DeleteMapping("/deleteById/{employeeId}")
    public String deleteById(@PathVariable Integer employeeId){
        employeeService.deleteById(employeeId);
        return "success";
    }
    @PatchMapping("/updateParticularRecord/{employeeId}/{address}")
    public String updateParticularRecord(@PathVariable Integer employeeId, @PathVariable String address){
        String s = employeeService.updateParticularRecord(employeeId,address);
        return s;
    }
}
