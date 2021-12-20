package com.performance.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.performance.Dao.LoginDao;
import com.performance.configuration.HibernateConfiguration;
import com.performance.entity.User;
import com.performance.request.LoginRequest;

@Repository("login")
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
@Configuration
@EnableTransactionManagement
public class LoginDaoImpl extends HibernateConfiguration implements LoginDao{

	@Override
	public int authenticate(LoginRequest request) {
		// TODO Auto-generated method stub
		String sql="SELECT id, \"password\", username\r\n" + 
				"FROM spm.users\r\n" + 
				"WHERE username=:username AND \"password\"=:password";
		HibernateTransactionManager txm=transactionManager();
		Session session = txm.getSessionFactory().getCurrentSession();
		NativeQuery query = session.createNativeQuery(sql);
		
		query.setParameter("username",request.getUserName());
		query.setParameter("password",request.getPassword());
		List<Object[]> res=query.list();
		if(res.size()==0) return 0;
		return 1;
	}

	public int searchByUsername(String username) {
		
		String sql="SELECT id, \"password\", username\r\n" + 
				"FROM spm.users\r\n" + 
				"WHERE username=:username";
		HibernateTransactionManager txm=transactionManager();
		Session session = txm.getSessionFactory().getCurrentSession();
		NativeQuery query = session.createNativeQuery(sql);
		
		query.setParameter("username",username);
		List<Object[]> res=query.list();
		
		if(res.size()>0) return 1;
		return 0;
	}
	
	@Override
	public int saveUser(LoginRequest request) {
		// TODO Auto-generated method stub
		
		int val=searchByUsername(request.getUserName());
		if(val==1) return 0;
		
		String sql = "INSERT INTO spm.users\r\n" + 
				"(\"password\", username)\r\n" + 
				"VALUES(:username, :password);\r\n" + 
				"";
		
		HibernateTransactionManager txm=transactionManager();
		Session session = txm.getSessionFactory().getCurrentSession();
		NativeQuery query = session.createNativeQuery(sql);
		//query.setParameter("id", id);
		query.setParameter("username", request.getPassword());
		query.setParameter("password", request.getUserName());
		query.executeUpdate();
		return 1;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM spm.users;";
		
		HibernateTransactionManager txm=transactionManager();
		Session session = txm.getSessionFactory().getCurrentSession();
		NativeQuery query = session.createNativeQuery(sql);
		List<Object[]> res=query.list();
		
		List<User> resList=new ArrayList<>();
		for(int i=0;i<res.size();i++) {
			User temp=new User();
			temp.setId((int)res.get(i)[0]);
			temp.setPassword((String)res.get(i)[1]);
			temp.setUserName((String)res.get(i)[2]);
			resList.add(temp);
		}
		return resList;
	}

}
