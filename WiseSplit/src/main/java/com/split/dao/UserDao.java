package com.split.dao;

import org.springframework.stereotype.Component;

import com.split.entity.user;


@Component
public interface UserDao {
	
	public void saveUserInformation(user userBean);
	
	public user getUsers(String email);
	
	public String updateUser(user user);
	
}
