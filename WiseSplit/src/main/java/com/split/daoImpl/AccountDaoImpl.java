package com.split.daoImpl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.split.dao.AccountDao;
import com.split.entity.Account;


@Component
public class AccountDaoImpl implements AccountDao {
	
	
	@Autowired
	EntityManager em;

	@Override
	@Transactional
	public void saveAccount(Account account) {
		
		em.persist(account);
		
	}

}
