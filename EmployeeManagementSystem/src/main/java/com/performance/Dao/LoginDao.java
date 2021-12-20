package com.performance.Dao;

import java.util.List;

import com.performance.entity.User;
import com.performance.request.LoginRequest;

public interface LoginDao {
	int authenticate(LoginRequest request);
	
	int saveUser(LoginRequest request);
	
	List<User> getAllUsers();
}
