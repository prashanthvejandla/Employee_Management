package com.performance.DaoImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.performance.Dao.EmployeeDao;
import com.performance.configuration.HibernateConfiguration;
import com.performance.entity.Employee;
import com.performance.request.EmployeeInsertRequest;
import com.performance.request.FilterRequest;

@Repository("postgres")
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
@Configuration
@EnableTransactionManagement
public class EmployeeDaoImpl extends HibernateConfiguration implements EmployeeDao {

	@Override
	public int insertEmployee(EmployeeInsertRequest request) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO spm.employee\r\n" + 
				"(id, address, dob, firstname, joindate, lastname, \"role\", salaryinlakhs, teamname)\r\n" + 
				"VALUES(:id, :address, :dob, :firstname, :joindate, :lastname, :role, :salaryinlakhs, :teamname);";
		
		HibernateTransactionManager txm=transactionManager();
		Session session = txm.getSessionFactory().getCurrentSession();
		NativeQuery query = session.createNativeQuery(sql);
		
		query.setParameter("id",request.getId());
		query.setParameter("address",request.getAddress());
		query.setParameter("dob",request.getDob());
		query.setParameter("firstname",request.getFirstName());
		query.setParameter("joindate", request.getJoinDate());
		query.setParameter("lastname",request.getLastName());
		query.setParameter("role",request.getRole());
		query.setParameter("salaryinlakhs",request.getSalaryInLakhs());
		query.setParameter("teamname",request.getTeamName());
		
		query.executeUpdate();
		
		return 1;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		
		String sql="SELECT id, address, dob, firstname, joindate, lastname, \"role\", salaryinlakhs, teamname\r\n" + 
				"FROM spm.employee;";
		
		HibernateTransactionManager txm=transactionManager();
		Session session=txm.getSessionFactory().getCurrentSession();
		NativeQuery query = session.createNativeQuery(sql);
		List<Object[]> res=query.list();
		
		List<Employee> resList=new ArrayList<Employee>();
		
		for(int i=0;i<res.size();i++) {
			Employee temp=new Employee();
			
			temp.setId((int)res.get(i)[0]);
			temp.setAddress((String)res.get(i)[1]);
			temp.setDob((String)res.get(i)[2]);
			temp.setFirstName((String)res.get(i)[3]);
			temp.setJoinDate((String)res.get(i)[4]);
			temp.setLastName((String)res.get(i)[5]);
			temp.setRole((String)res.get(i)[6]);
			temp.setSalaryInLakhs((double)res.get(i)[7]);
			temp.setTeamName((String)res.get(i)[8]);
			
			resList.add(temp);
		}
		
		return resList;
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM spm.employee WHERE id = :id";
		
		HibernateTransactionManager txm=transactionManager();
		Session session=txm.getSessionFactory().getCurrentSession();
		NativeQuery query = session.createNativeQuery(sql);
		query.setParameter("id", id);
		List<Object[]> res=query.list();
		List<Employee> resList=new ArrayList<Employee>();
		
		for(int i=0;i<res.size();i++) {
			Employee temp=new Employee();
			temp.setId((int)res.get(i)[0]);
			temp.setAddress((String)res.get(i)[1]);
			temp.setDob((String)res.get(i)[2]);
			temp.setFirstName((String)res.get(i)[3]);
			temp.setJoinDate((String)res.get(i)[4]);
			temp.setLastName((String)res.get(i)[5]);
			temp.setRole((String)res.get(i)[6]);
			temp.setSalaryInLakhs((double)res.get(i)[7]);
			temp.setTeamName((String)res.get(i)[8]);
			resList.add(temp);
		}
		return resList.stream().findFirst();
	}

	@Override
	public int updateEmployeeById(int id, Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> employeeMaybe=getEmployeeById(id);
		if(employeeMaybe.isEmpty()) return 0;
		
		String sql="UPDATE spm.employee SET address=:address ,dob=:dob ,firstname=:firstname ,joindate=:joindate ,lastname=:lastname ,role=:role ,salaryinlakhs=:salaryinlakhs ,teamname=:teamname WHERE id=:id";
		
		HibernateTransactionManager txm=transactionManager();
		Session session=txm.getSessionFactory().getCurrentSession();
		NativeQuery query = session.createNativeQuery(sql);
		query.setParameter("id", id);
		query.setParameter("address", employee.getAddress());
		query.setParameter("dob", employee.getDob());
		query.setParameter("firstname", employee.getFirstName());
		query.setParameter("joindate", employee.getJoinDate());
		query.setParameter("lastname", employee.getLastName());
		query.setParameter("role", employee.getRole());
		query.setParameter("salaryinlakhs", employee.getSalaryInLakhs());
		query.setParameter("teamname", employee.getTeamName());
		query.executeUpdate();
		return 1;
	}

	@Override
	public int deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> employeeMaybe=getEmployeeById(id);
		if(employeeMaybe.isEmpty()) return 0;
		
		String sql="DELETE FROM spm.employee WHERE id=:id";
		
		HibernateTransactionManager txm=transactionManager();
		Session session=txm.getSessionFactory().getCurrentSession();
		NativeQuery query = session.createNativeQuery(sql);
		query.setParameter("id", id);
		query.executeUpdate();
		return 1;
	}

	@Override
	public List<Employee> searchEmployeeByName(String name) {
		// TODO Auto-generated method stub
		String sql="SELECT id, address, dob, firstname, joindate, lastname, \"role\", salaryinlakhs, teamname\r\n" + 
				"FROM spm.employee\r\n" + 
				"WHERE firstname=:name OR lastname=:name";
		
		HibernateTransactionManager txm=transactionManager();
		Session session=txm.getSessionFactory().getCurrentSession();
		NativeQuery query = session.createNativeQuery(sql);
		query.setParameter("name", name);
		List<Object[]> res=query.list();
		List<Employee> resList=new ArrayList<Employee>();
		
		for(int i=0;i<res.size();i++) {
			Employee temp=new Employee();
			temp.setId((int)res.get(i)[0]);
			temp.setAddress((String)res.get(i)[1]);
			temp.setDob((String)res.get(i)[2]);
			temp.setFirstName((String)res.get(i)[3]);
			temp.setJoinDate((String)res.get(i)[4]);
			temp.setLastName((String)res.get(i)[5]);
			temp.setRole((String)res.get(i)[6]);
			temp.setSalaryInLakhs((double)res.get(i)[7]);
			temp.setTeamName((String)res.get(i)[8]);
			resList.add(temp);
		}
		return resList;
	}

	@Override
	public List<Employee> filterEmployees(FilterRequest request) {
		// TODO Auto-generated method stub
		String sql="";
		int lev=request.getLevel();
		HibernateTransactionManager txm=transactionManager();
		Session session=txm.getSessionFactory().getCurrentSession();
		NativeQuery query;
		if(lev==1) {
			sql="SELECT id, address, dob, firstname, joindate, lastname, \"role\", salaryinlakhs, teamname\r\n" + 
					"FROM spm.employee\r\n" + 
					"WHERE teamname=:teamname";
			query = session.createNativeQuery(sql);
			query.setParameter("teamname", request.getTeamName());
		}
		else if(lev==2) {
			sql="SELECT id, address, dob, firstname, joindate, lastname, \"role\", salaryinlakhs, teamname\r\n" + 
					"FROM spm.employee\r\n" + 
					"WHERE role=:role";
			query = session.createNativeQuery(sql);
			query.setParameter("role", request.getRole());
		}
		else if(lev==3){
			sql="SELECT id, address, dob, firstname, joindate, lastname, \"role\", salaryinlakhs, teamname\r\n" + 
					"FROM spm.employee\r\n" + 
					"WHERE teamname=:teamname AND role=:role";
			query = session.createNativeQuery(sql);
			query.setParameter("teamname", request.getTeamName());
			query.setParameter("role", request.getRole());
		}
		else {
			sql="SELECT id, address, dob, firstname, joindate, lastname, \"role\", salaryinlakhs, teamname\r\n" + 
					"FROM spm.employee;\r\n" + 
					"";
			query = session.createNativeQuery(sql);
		}
		
		List<Object[]> res=query.list();
		List<Employee> resList=new ArrayList<Employee>();
		
		for(int i=0;i<res.size();i++) {
			Employee temp=new Employee();
			temp.setId((int)res.get(i)[0]);
			temp.setAddress((String)res.get(i)[1]);
			temp.setDob((String)res.get(i)[2]);
			temp.setFirstName((String)res.get(i)[3]);
			temp.setJoinDate((String)res.get(i)[4]);
			temp.setLastName((String)res.get(i)[5]);
			temp.setRole((String)res.get(i)[6]);
			temp.setSalaryInLakhs((double)res.get(i)[7]);
			temp.setTeamName((String)res.get(i)[8]);
			resList.add(temp);
		}
		return resList;
	}

}
