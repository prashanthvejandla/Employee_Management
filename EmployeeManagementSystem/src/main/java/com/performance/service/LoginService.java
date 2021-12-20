package com.performance.service;

import java.util.List;

import com.performance.entity.User;
import com.performance.request.LoginRequest;

public interface LoginService {
	
	int authenticate(LoginRequest request);
	
	int saveUser(LoginRequest request);
	
	List<User> getAllUsers();
}
