package com.performance.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.performance.Dao.EmployeeDao;
import com.performance.entity.Employee;
import com.performance.request.EmployeeInsertRequest;
import com.performance.request.FilterRequest;
import com.performance.service.EmployeeService;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("postgres")
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional("transactionOrclManager")
	public int addEmployee(EmployeeInsertRequest request) {
		// TODO Auto-generated method stub
		return employeeDao.addEmployee(request);
	}

	@Override
	@Transactional("transactionOrclManager")
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getEmployees();
	}

	@Override
	@Transactional("transactionOrclManager")
	public Optional<Employee> getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeById(id);
	}

	@Override
	@Transactional("transactionOrclManager")
	public int updateEmployeeById(int id, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployeeById(id, employee);
	}

	@Override
	@Transactional("transactionOrclManager")
	public int deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployeeById(id);
	}

	@Override
	@Transactional("transactionOrclManager")
	public List<Employee> searchEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return employeeDao.searchEmployeeByName(name);
	}

	@Override
	public List<Employee> filterEmployees(FilterRequest request) {
		// TODO Auto-generated method stub
		return employeeDao.filterEmployees(request);
	}

}
