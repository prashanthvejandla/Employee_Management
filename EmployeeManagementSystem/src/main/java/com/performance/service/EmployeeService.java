package com.performance.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.performance.entity.Employee;
import com.performance.request.EmployeeInsertRequest;
import com.performance.request.FilterRequest;


public interface EmployeeService {
	
	int addEmployee(EmployeeInsertRequest request);
	
	List<Employee> getEmployees();
	
	Optional<Employee> getEmployeeById(int id);
	
	List<Employee> searchEmployeeByName(String name);
	
	List<Employee> filterEmployees(FilterRequest request);
	
	int updateEmployeeById(int id, Employee employee);
	
	int deleteEmployeeById(int id);
}
