package com.performance.Dao;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import com.performance.entity.Employee;
import com.performance.request.EmployeeInsertRequest;
import com.performance.request.FilterRequest;

public interface EmployeeDao {
	int insertEmployee(EmployeeInsertRequest request);
	
	List<Employee> getEmployees();
	
	Optional<Employee> getEmployeeById(int id);
	
	int updateEmployeeById(int id, Employee employee);
	
	int deleteEmployeeById(int id);
	
	List<Employee> searchEmployeeByName(String name);
	
	List<Employee> filterEmployees(FilterRequest request);
	
	default int addEmployee(EmployeeInsertRequest request) {
		Random rand=new Random();
		int id = rand.nextInt(999999 - 100000 + 1) + 100000;
		request.setId(id);
		return insertEmployee(request);
	}
}
