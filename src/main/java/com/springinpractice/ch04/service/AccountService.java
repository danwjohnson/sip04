package com.springinpractice.ch04.service;

import org.springframework.validation.Errors;

import com.springinpractice.ch04.domain.Account;

public interface AccountService {

	boolean registerAccount(Account account, String password, Errors errors);
	
} // end AccountService interface
