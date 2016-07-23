package com.sinoway.sinowayCrawer.entitys;

import java.util.Date;

import com.sinoway.sinowayCrawer.utils.DateUtils;



public class UserInfo {
	
	public static final Integer STATUS_FLAG_OPEN = 0;
	public static final Integer STATUS_FLAG_CLOSE = 1;
	
    private String account;

    private String password;

    private String name;
    private String email;
    private String phone;
    
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public static Integer getStatusFlagOpen() {
		return STATUS_FLAG_OPEN;
	}
	public static Integer getStatusFlagClose() {
		return STATUS_FLAG_CLOSE;
	}
	
    
 

}