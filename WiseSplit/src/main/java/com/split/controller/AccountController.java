package com.split.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.split.bean.AccountBean;
import com.split.bean.AddRequestBean;
import com.split.bean.RequestBean;
import com.split.bean.ResponseBean;
import com.split.dao.AccountDao;
import com.split.entity.Account;
import com.split.service.AccountService;
import com.split.util.LoggerExt;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@Autowired
	LoggerExt logger;

	@Autowired
	AccountDao accountDao;

	@RequestMapping(value = "v1/addMoney", method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> addMoney(@RequestBody AddRequestBean addRequestBean) {

		ResponseBean obj = new ResponseBean();
		System.out.println("in controller");

		System.out.println("Amount : " + addRequestBean.getAmount());
		System.out.println("Comment : " + addRequestBean.getComment());
		System.out.println("UserId : " + addRequestBean.getUserId());

		try {

			if (addRequestBean.getUserId() != 0) {
				accountService.addAmount(addRequestBean);
			}
		} catch (Exception ex) {
			logger.debug("AccountController", "Exceptio occured in AccountController Class");
		}

		obj.setStatus("MoneyAddedSuccessfully");

		return new ResponseEntity<ResponseBean>(obj, HttpStatus.OK);

		/*
		 * Account obj = new Account();
		 * 
		 * user objj = new user();
		 * 
		 * objj.setEmailId("User1@gmail.com"); objj.setFirstName("User1");
		 * objj.setLastName("User1");
		 * 
		 * obj.setAmount(2000); obj.setComment("SecondComment");
		 * obj.setIsactive(BigDecimal.ONE);
		 * obj.setLastupdateddate(CommonUtil.getSystemDate()); obj.setUser(objj);
		 * 
		 * AaccountDao.saveAccount(obj);
		 */

	}

	@RequestMapping(value = "/v1/calculation", method = RequestMethod.GET)
	public ResponseEntity<List<AccountBean>> monthlyCalculation() {

		List<Account> newList;
		newList = accountDao.getResult();
		
		List<AccountBean> list = null;
		AccountBean bean = null;

		for (Account itr : newList) {
			bean = new AccountBean();
			bean.setAmount(itr.getAmount());
			bean.setComment(itr.getComment());
			System.out.println("from controller " +bean.getAmount());
			
		}
		list.add(bean);
		
		return new ResponseEntity<List<AccountBean>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "v1/calculationAccount", method = RequestMethod.GET)
	public List<AccountBean> monthlyCalculationAccount() {

		List<AccountBean> newList;
		newList = accountDao.getAccount();

		List<AccountBean> list = new ArrayList<>();
		AccountBean bean = null;

		/*for (AccountBean itr : newList) {
			bean = new AccountBean();
			bean.setAmount(itr.getAmount());
			bean.setComment(itr.getComment());
			list.add(bean);
		}*/

		return newList;
	}
	
	
	//ErrorEndpoint
	
	/*// error  =={
	"timestamp": "2018-08-08T17:26:43.630+0000",
	"status": 500,
	"error": "Internal Server Error",
	"message": "[Ljava.lang.Object; cannot be cast to com.split.bean.AccountBean",
	"path": "/v1/calculationAccount"
	}*/
	
	/*@RequestMapping(value = "v1/calculationAccount", method = RequestMethod.GET)
	public ResponseEntity<List<CalculationBean>> monthlyCalculationAccount() {

		List<AccountBean> newList;
		newList = accountDao.getAccount();

		List<CalculationBean> list = new ArrayList<>();
		CalculationBean bean = null;

		for (AccountBean itr : newList) {
			bean = new CalculationBean();
			bean.setAmount(itr.getAmount());
			bean.setComment(itr.getComment());
			System.out.println("from controllleer"  +bean.getAmount());
			list.add(bean);
		}

		return new ResponseEntity<List<CalculationBean>>(list, HttpStatus.OK);
	}*/


	@RequestMapping(value = "v1/calculationAccountByDate", method = RequestMethod.POST)
	public List<AccountBean> monthlyCalculationAccountByDate(@RequestBody RequestBean requestBean) {

		List<AccountBean> newList;
		newList = accountService.getAccountByDate(requestBean);

		List<AccountBean> list = new ArrayList<>();
		AccountBean bean = null;

		/*
		 * for(Account itr : newList ) { bean = new AccountBean();
		 * bean.setAmount(itr.getAmount()); bean.setComment(itr.getComment());
		 * list.add(bean); }
		 */

		return newList;
	}

}
