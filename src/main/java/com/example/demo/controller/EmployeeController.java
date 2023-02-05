package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.service.EmloyeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	
	private EmloyeeService empService;
	
	
	@GetMapping("/")
	
	public String viewHomePage(Model model){
		
		model.addAttribute("listEmployees", empService.getAllEmployees());
		
		return "index";
	}
	
	
	@GetMapping("/shownewemployeeform")
	public String shownewemployeeform(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		empService.saveEmployee(employee);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value="id") long id , Model model ) {
		// get employee from service
		Employee employee =empService.getEmployeebyId(id);
		
		model.addAttribute("employee",employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value="id") long id , Model model ) {
		// get employee from service
	     this.empService.deleteEmployeebyId(id);
	     
			return "redirect:/";
	}

}
