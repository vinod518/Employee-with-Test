package com.org.tcs.service;

import com.org.tcs.model.Employee;
import com.org.tcs.repository.EmployeeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceImpTest {
    @InjectMocks
    private EmployeeServiceImp employeeServiceImp;
    @Mock
    private  EmployeeRepo employeeRepo;
    @Test
    void createEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeId(100);
        employee.setEmployeeName("vinod");
        employee.setEmployeeAddress("srikakulam");
        employee.setEmployeeSalary(150000);
        employeeServiceImp.createEmployee(employee);
        Mockito.verify(employeeRepo,Mockito.times(1)).save(employee);
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeId(100);
        employee.setEmployeeName("bora");
        employee.setEmployeeAddress("andhrapradesh");
        employee.setEmployeeSalary(100000);
        employeeServiceImp.updateEmployee(employee);
        Mockito.verify(employeeRepo, Mockito.times(1)).save(employee);
    }

    @Test
    void getAll() {
        List<Employee> le = new ArrayList<>();
        Employee emp = new Employee();
        emp.setEmployeeId(101);
        emp.setEmployeeName("vinodkumar");
        emp.setEmployeeAddress("gulumuru");
        emp.setEmployeeSalary(100000);
        le.add(emp);
        Employee emp1 = new Employee();
        emp1.setEmployeeId(102);
        emp1.setEmployeeName("pramodh");
        emp1.setEmployeeAddress("hiramandalam");
        emp1.setEmployeeSalary(300000);
        le.add(emp1);
        Mockito.when(employeeRepo.findAll()).thenReturn(le);
        List<Employee> le2 = employeeServiceImp.getAll();
        Assertions.assertEquals(le,le2);
    }
    @Test
    void getById() {
        int employeeId=101;
        String address="srikakulam";
        Employee emp2 = new Employee();
        emp2.setEmployeeId(101);
        emp2.setEmployeeAddress("srikakulam");
        Optional<Employee> optional = Optional.of(emp2);
        Mockito.when(employeeRepo.findById(employeeId)).thenReturn(optional);
        Optional<Employee> optional1 = employeeServiceImp.getById(employeeId);
        Assertions.assertEquals(optional1,optional);

    }

    @Test
    void deleteById() {
        int employeeId=101;
        String str = "success";
        String str1 = employeeServiceImp.deleteById(employeeId);
        Mockito.verify(employeeRepo,Mockito.times(1)).deleteById(employeeId);
        Assertions.assertEquals(str,str1);
    }

    @Test
    void updateParticularRecord() {
        int employeeId=101;
        String employeeAddress="gulumuru";
        String str = "success";
        Employee emp = new Employee();
        emp.setEmployeeId(101);
        emp.setEmployeeAddress("gulumuru");
        Optional<Employee> optional = Optional.of(emp);
        Mockito.when(employeeRepo.findById(employeeId)).thenReturn(optional);
        String str1 = employeeServiceImp.updateParticularRecord(employeeId,employeeAddress);
        Assertions.assertEquals(str,str1);
    }
}