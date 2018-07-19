package com.split.service;

import org.springframework.stereotype.Component;

import com.split.bean.userBean;

@Component
public interface UserService {
	
	public String saveUserInformation(userBean userbean);

	
	public String updateUser(userBean userbean);
	
	public String deleteUser(String emailId);
}
