package com.split.dao;

import org.springframework.stereotype.Component;

import com.split.entity.Account;

@Component
public interface AccountDao {
	
	public void saveAccount(Account account);

}
