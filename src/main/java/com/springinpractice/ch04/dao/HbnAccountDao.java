package com.springinpractice.ch04.dao;

import javax.inject.Inject;

import org.hibernate.Query;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springinpractice.ch04.domain.Account;
import com.springinpractice.dao.hibernate.AbstractHbnDao;

public class HbnAccountDao extends AbstractHbnDao<Account> implements AccountDao{

	private static final String UPDATE_PASSWORD_SQL =
			"update account set password = ? where username = ?";
	
	@Inject private JdbcTemplate jdbcTemplate;
	
	public void create(Account account, String password) {
		
		create(account);
		jdbcTemplate.update(UPDATE_PASSWORD_SQL, password, account.getUsername());
		
	} // end create()
	
	
	public Account findByUsername(String username) {
		
		Query q = getSession().getNamedQuery("findAccountByUsername");
		q.setParameter("username", username);
		return (Account) q.uniqueResult();
		
	} // end findByUserName()
	
} // end HbnAccountDao class
