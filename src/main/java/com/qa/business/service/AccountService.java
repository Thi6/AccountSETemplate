package com.qa.business.service;

public interface AccountService {
	
	String addAccount(String account);
	
	String getAllAccounts();
	
	String findAnAccount(int id);
	
	String deleteAccount(int id);
	
}
