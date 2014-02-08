package com.springinpractice.ch04.service;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.springinpractice.ch04.dao.AccountDao;
import com.springinpractice.ch04.domain.Account;

public class AccountServiceImpl implements AccountService {

	@Inject private AccountDao accountDao;
	
	@Transactional(readOnly = false)
	public boolean registerAccount(
			Account account, String password, Errors errors) {
		
		validateUsername(account.getUsername(), errors);
		boolean valid = !errors.hasErrors();
		if (valid) {
			
			accountDao.create(account, password);
		
		} // end if
		
		return valid;
		
	} // end registerAccount()
	
	
	private void validateUsername(String username, Errors errors) {
		
		if (accountDao.findByUsername(username) != null) {
			
			errors.rejectValue("username", "error.duplicate",
					new String[] {username}, null);
			
		} // end if
		
	} // end validateUsername()
	
} // end AccountServiceImpl class
