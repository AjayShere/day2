package com.split.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.split.bean.userBean;
import com.split.dao.UserDao;
import com.split.entity.user;
import com.split.service.UserService;
import com.split.util.LoggerExt;

@RestController
 public class UserController {
	
	@Autowired
	UserService user;
	
	@Autowired
	LoggerExt logger;
	
	@Autowired
	UserDao userDao;
	
	
	@RequestMapping(value ="createUser" , method = RequestMethod.POST)
 	public String saveUser(@RequestBody userBean userbean) {
		
		String status =null;
 		logger.debug("saveUser.conrtroller", "In user Controller");
 		
 		if(null != userbean.getEmailId()) {
 			status = user.saveUserInformation(userbean);
 		}
 		
 		else {
 			System.out.println("NullEmail");
 		}
 		
 		logger.debug("saveUser.conrtroller", "End user Controller");
		System.out.println("Out From Method SaveUser");
		return status;
	}
 	
	
	@RequestMapping(value ="/v1/updateUser" , method = RequestMethod.POST)
 	public user updateUser(@RequestBody userBean userbean) {
		
		
		/*user obj = new user();
		
		obj =userDao.getUsers(userbean.getEmailId());*/
		if(null != userbean.getEmailId()) {
			user.updateUser(userbean);
		}
		return null;
	}
 	
 	@RequestMapping(value="v1/deleteUser" , method =RequestMethod.POST)
 	public void deleteUser(@RequestBody String emailId) {
 		
 		user.deleteUser(emailId);
 		
 		
 	}
 	
 	
 	
	
}
