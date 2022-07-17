package com.org.tcs.service;

import com.org.tcs.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public void createEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public List<Employee> getAll();
    public Optional<Employee> getById(Integer id);
    public String deleteById(Integer id);
    public String updateParticularRecord(Integer id, String address);
}
