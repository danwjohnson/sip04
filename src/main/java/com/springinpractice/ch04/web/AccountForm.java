package com.springinpractice.ch04.web;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.ScriptAssert;

@ScriptAssert(
		lang = "javascript",
		script = "_this.confirmPassword.equals(_this.password)",
		message = "account.password.mismatch.message")
public class AccountForm {

	private String username;
	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;
	private String email;
	
	private boolean marketingOk = true;
	private boolean acceptTerms = false;
	
	
	@NotNull
	@Size(min = 1, max = 50)
	public String getUsername() {
		
		return username;
		
	} // end getUsername()
	
	
	public void setUsername(String username) {
		
		this.username = username;
		
	} // end setUsername()
	
	@NotNull
	@Size(min = 6, max = 50)
	public String getPassword() {
		
		return password;
		
	} // end getPassword()
	
	
	public void setPassword(String password) {
		
		this.password = password;
		
	} // end setPassword()
	
	
	public String getConfirmPassword() {
		
		return confirmPassword;
		
	} //end getConfirmPassword()
	
	
	public void setConfirmPassword(String confirmPassword) {
		
		this.confirmPassword = confirmPassword;
		
	} // end setConfirmPassword()
	
	
	@NotNull
	@Size(min = 6, max = 50)
	public String getFirstName() {
		
		return firstName;
		
	} // end getFirstName()
	
	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
		
	} // end setFirstName()
	
	
	@NotNull
	@Size(min = 6, max = 50)
	public String getLastName() {
		
		return lastName;
		
	} //end getLastName()
	
	
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
		
	} // end setLastName()
	
	@NotNull
	@Size(min = 6, max = 50)
	@Email
	public String getEmail() {
		
		return email;
		
	} // end setEmail()
	
	
	public void setEmail(String email) {
		
		this.email = email;
		
	} // end setEmail()
	
	
	public boolean isMarketingOk() {
		
		return marketingOk;
		
	} // end getMarketingOk()
	
	
	public void setMarketingOk(boolean marketingOk) {
		
		this.marketingOk = marketingOk;
		
	} // end setMarketingOk()
	
	
	@AssertTrue(message = "{account.acceptTerms.assertTrue.message}")
	public boolean getAcceptTerms() {
		
		return acceptTerms;
		
	} // end getAcceptTerms()
	
	
	public void setAcceptTerms(boolean acceptTerms) {
		
		this.acceptTerms = acceptTerms;
		
	} // end setAcceptTerms()
	
	
	public String toString() {
		
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append("username", username)
			.append("firstName", firstName)
			.append("lastName", lastName)
			.append("email", email)
			.append("marketingOk", marketingOk)
			.append("acceptTeerms", acceptTerms)
			.toString();
		
	} // end toString()
	
} // end AccountForm class
