package com.shobha.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shobha.basic.model.Employee;
import com.shobha.basic.services.EmployeeService;

@RestController
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee)
	{
		employeeService.addEmployee(employee);
		return "Add Employee Record Successfully";
	}
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	@GetMapping("/getEmployee/{empNo}")
	public Employee getEmployee(@PathVariable Integer empNo)
	{
		return employeeService.getEmployee(empNo);
	}
	@PutMapping("updateEmployee")
	Employee updateEmployee(@RequestBody Employee employee)
	{
		return employeeService.updateEmployee(employee);
	}
	@DeleteMapping("deleteEmployee")
	public String deleteEmployee(Integer empNo)
	{
		employeeService.deleteEmployee(empNo);
		return "Object Deleted";
	}

}
