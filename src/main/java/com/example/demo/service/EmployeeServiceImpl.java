package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmloyeeService {

	
	
	@Autowired 
	 private EmployeeRepository emprepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return emprepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.emprepository.save(employee);
		
	}

	@Override
	public Employee getEmployeebyId(long id) {
		Optional<Employee> optional = emprepository.findById(id);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			
			throw new RuntimeException("no Employee found for this id ::"+id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeebyId(long id) {
		
		this.emprepository.deleteById(id);
		
	}

}
