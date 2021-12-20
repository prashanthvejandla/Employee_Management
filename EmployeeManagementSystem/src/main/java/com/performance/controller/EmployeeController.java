package com.performance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.performance.entity.Employee;
import com.performance.request.EmployeeInsertRequest;
import com.performance.request.FilterRequest;
import com.performance.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/addEmployee" , method=RequestMethod.POST)
	public int addEmployee(@RequestBody EmployeeInsertRequest request) {
		return employeeService.addEmployee(request);
	}
	
	@RequestMapping(value="/getEmployees" , method=RequestMethod.GET)
	public @ResponseBody List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@RequestMapping(value="/getEmployeeById/{id}" , method=RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable int id) {
		Optional<Employee> employeeMaybe = employeeService.getEmployeeById(id);
		if(employeeMaybe.isEmpty()) return null;
		return employeeMaybe.get();
	}
	
	@RequestMapping(value="/updateEmployeeById/{id}" , method=RequestMethod.PUT)
	public int updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {
		return employeeService.updateEmployeeById(id, employee);
	}
	
	@RequestMapping(value="/deleteEmployeeById/{id}" , method=RequestMethod.DELETE)
	public int deleteEmployeeById(@PathVariable int id) {
		return employeeService.deleteEmployeeById(id);
	}
	
	@RequestMapping(value="/searchEmployeeByName/{name}" , method=RequestMethod.GET)
	public @ResponseBody List<Employee> searchEmployeeByName(@PathVariable String name){
		return employeeService.searchEmployeeByName(name);
	}
	
	@RequestMapping(value="/filterEmployees" , method=RequestMethod.GET)
	public @ResponseBody List<Employee> filterEmployees(@RequestBody FilterRequest request){
		return employeeService.filterEmployees(request);
	}
}
