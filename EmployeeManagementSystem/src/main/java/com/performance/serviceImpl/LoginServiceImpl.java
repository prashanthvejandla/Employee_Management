package com.performance.serviceImpl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.performance.Dao.LoginDao;
import com.performance.entity.User;
import com.performance.request.LoginRequest;
import com.performance.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired()
	@Qualifier("login")
	private LoginDao loginDao;
	
	@Override
	@Transactional("transactionOrclManager")
	public int authenticate(LoginRequest request) {
		// TODO Auto-generated method stub
		return loginDao.authenticate(request);
	}

	@Override
	@Transactional("transactionOrclManager")
	public int saveUser(LoginRequest request) {
		// TODO Auto-generated method stub
		return loginDao.saveUser(request);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return loginDao.getAllUsers();
	}

}
