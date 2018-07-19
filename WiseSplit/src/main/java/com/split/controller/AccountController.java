package com.split.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.split.dao.AccountDao;
import com.split.entity.Account;
import com.split.entity.user;
import com.split.util.CommonUtil;

@RestController
public class AccountController {
	
	
	@Autowired
	AccountDao AaccountDao;
	
	@RequestMapping(value = "V1/addMoney" , method = RequestMethod.GET)
	public void addMoney() {
		
		Account obj = new Account();
		
		user objj = new user();
		
		objj.setEmailId("iamdd@gmail.com");
		objj.setFirstName("thor");
		objj.setLastName("odin");
		
		obj.setAmount(1000);
		obj.setComment("SecondComment");
		obj.setIsactive(BigDecimal.ONE);
		obj.setLastupdateddate(CommonUtil.getSystemDate());
		obj.setUser(objj);
		
		AaccountDao.saveAccount(obj);
		
	}
	
	
	

}
