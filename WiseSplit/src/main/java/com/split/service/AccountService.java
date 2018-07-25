package com.split.service;

import org.springframework.stereotype.Component;

import com.split.bean.AddRequestBean;


@Component
public interface AccountService {

	
	public void addAmount(AddRequestBean addRequestBean);
	
	public void getResult();
	
}
