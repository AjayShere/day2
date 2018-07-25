package com.split.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.split.bean.AddRequestBean;
import com.split.bean.FinalResponseBean;
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

	@Override
	public void saveAmount(AddRequestBean AddRequestBean) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public List<Account> getResult() {

		List<Account> results ;
		System.out.println("in dao");
        //String hqlQuery ="select sum(amount), id from account group by id";
        
        Query query =em.createQuery("from Account where isactive = 1");
        
        results =query.getResultList();
        
        System.out.println("response" +results.get(0));
        
        System.out.println("dao out");
		//List<FinalResponseBean> responseList =em.createQuery("from )
		return results;
	}

	@Override
	@Transactional
	public List<Account> getAccount() {
		
		
		
		Query query = em.createQuery("from Account where isactive = 1 ");
		
		List<Account> accountList =query.getResultList();
		
		return accountList;
	}

}
