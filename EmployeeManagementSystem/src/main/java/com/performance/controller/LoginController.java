package com.performance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.performance.entity.User;
import com.performance.request.LoginRequest;
import com.performance.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public int login(@RequestBody LoginRequest request) {
		return loginService.authenticate(request);
	}
	
	@RequestMapping(value="/signup" , method=RequestMethod.POST)
	public int saveUser(@RequestBody LoginRequest request) {
		return loginService.saveUser(request);
	}
	
	@RequestMapping(value="/getAllUsers" , method=RequestMethod.GET)
	public List<User> getAllUsers(){
		return loginService.getAllUsers();
	}
}
