package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmloyeeService {
	
	List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeebyId(long id);
    void deleteEmployeebyId(long id );
}
