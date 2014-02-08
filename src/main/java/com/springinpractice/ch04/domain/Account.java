package com.springinpractice.ch04.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


@NamedQuery(
		name = "findAccountByUsername",
		query = "from Account where username = :username")
@Entity
@Table (name="account")
public class Account {

	private Long id;
	private String username, firstName, lastName, email;
	private boolean marketingOk = true;
	private boolean acceptTerms = false;
	private boolean enabled = true;
	private Date dateCreated;
	
	
	/**
	 * Get the id of the account
	 * @return id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		
		return id;
	
	} // end getId()
	
	
	
	/**
	 * Set the id of the account
	 * @param id
	 */
	public void setId(Long id) {
		
		this.id = id;
	
	} // end setId()
	
	
	
	/**
	 * Get the user name of the account
	 * @return username
	 */
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "username")
	public String getUsername() {
		
		return username;
	
	} // end getUsername()
	
	
	
	/**
	 * Set the user name of the account
	 * @param username
	 */
	public void setUsername(String username) {
		
		this.username = username;
	
	} // end setUsername()
	
	
	
	/**
	 * Get the first name of the account
	 * @return firsName
	 */
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "first_name")
	public String getFirstName() {
		
		return firstName;
	
	} // end getFirstName()
	
	
	
	/**
	 * Set the first name of the account
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	
	}
	
	
	
	/**
	 * Get the last name of the account
	 * @return lastName
	 */
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name="last_name")
	public String getLastName() {
	
		return lastName;
	
	} // end getLastName()
	
	
	
	/**
	 * Set the last name of the account
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
	
	} // end setLastName()
	
	
	
	/**
	 * Get the first name and last name of the account
	 * @return firstName + lastName
	 */
	@Transient
	public String getFullName() {
		
		return firstName + " " + lastName;
		
	} // end getFullName()
	
	
	/**
	 * Get the email of the account
	 * @return email
	 */
	@NotNull
	@Size( min = 6, max = 50)
	@Email
	@Column(name = "email")
	public String getEmail() {
		
		return email;
	
	} // end getEmail()
	
	
	/**
	 * Set the email of the account
	 * @param email
	 */
	public void setEmail(String email) {
		
		this.email = email;
	
	} // end setEmail()
	
	
	
	/**
	 * Get the marketing ok flag for the account
	 * @return marketingOk
	 */
	@Column(name = "marketing_ok")
	public boolean isMarketingOk() {
		
		return marketingOk;
	
	} // end isMarketingOk()
	
	
	
	/**
	 * Set the marketing ok flag for the account
	 * @param marketingOk
	 */
	public void setMarketingOk(boolean marketingOk) {
		this.marketingOk = marketingOk;
	} // end setMarketingOk()
	
	
	
	/**
	 * Get the accept terms flag for the account
	 * @return acceptTerms
	 */
	@AssertTrue(message = "{account.acceptTerms.assertTrue.message}")
	@Column(name = "accept_terms")
	public boolean getAcceptTerms() {
		
		return acceptTerms;
	
	} // end getAcceptTerms()
	
	
	
	/**
	 * Set the accept terms flag for the account
	 * @param acceptTerms
	 */
	public void setAcceptTerms(boolean acceptTerms) {
		
		this.acceptTerms = acceptTerms;
	
	} // end setAcceptTerms()
	
	
	
	
	/**
	 * Get the is enabled flag for the account
	 * @return enabled
	 */
	@Column(name = "enabled")
	public boolean isEnabled() {
		
		return enabled;
	
	} // end enabled()
	
	
	
	/**
	 * Set the is enabled flag for the account
	 * @param enabled
	 */
	public void setEnabled(boolean enabled) {
		
		this.enabled = enabled;
	
	} // end setEnabled()
	
	
	
	/**
	 * Get the date created of the account
	 * @return dateCreated
	 */
	@Column(name = "date_created")
	public Date getDateCreated() {
		
		return dateCreated;
	
	} // end getDateCreated()
	
	
	
	/**
	 * Set the date created of the account
	 * @param dateCreated
	 */
	public void setDateCreated(Date dateCreated) {
		
		this.dateCreated = dateCreated;
	
	} // end setDateCreated()
	
} // end Account class
