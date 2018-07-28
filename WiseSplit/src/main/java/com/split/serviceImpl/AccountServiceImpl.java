package com.split.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.split.bean.AddRequestBean;
import com.split.dao.AccountDao;
import com.split.dao.UserDao;
import com.split.entity.Account;
import com.split.entity.user;
import com.split.service.AccountService;
import com.split.util.CommonUtil;


@Component
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	UserDao userDao;

	@Override
	public void addAmount(AddRequestBean addRequestBean) {

		Account account = new Account();
		if(addRequestBean.getAmount() != 0  && addRequestBean.getUserId() != 0) {
			
			user userObj = userDao.getUser(addRequestBean.getUserId());
			if(null != userObj) {
			account.setUser(userObj);
			}
			account.setAmount(addRequestBean.getAmount());
			account.setComment(addRequestBean.getComment());
			account.setIsactive(BigDecimal.ONE);
			account.setLastupdateddate(CommonUtil.getSystemDate());
			
			
			accountDao.saveAccount(account);
			
		}
		
		
		
	}

	@Override
	public void getResult() {
		// TODO Auto-generated method stub
		
	}

	/*public void getResult() {
		// TODO Auto-generated method stub
		
		List<Account> list =accountDao.getAccount();
		List<AddRequestBean> AddRequestBeanList =new ArrayList<>();
		
		
		for(Account  list1 : list) {
			
			
		}
		
	}
*/
}
