package com.org.tcs.service;

import com.org.tcs.model.Employee;
import com.org.tcs.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public void createEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> emp = employeeRepo.findAll();
        return emp;
    }

    @Override
    public Optional<Employee> getById(Integer employeeId) {
        Optional<Employee> e = employeeRepo.findById(employeeId);
        return e;
    }

    @Override
    public String deleteById(Integer employeeId) {
        employeeRepo.deleteById(employeeId);
        return "success";
    }

    @Override
    public String updateParticularRecord(Integer employeeId, String address) {
        Optional<Employee> oe = employeeRepo.findById(employeeId);
        Employee emp1 = oe.get();
        emp1.setEmployeeAddress(address);
        employeeRepo.save(emp1);
        return "success";
    }
}









