package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.AccountRepository;

public class AccountServiceImpl implements AccountService{

	@Inject
	private AccountRepository repo;
	
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}
	

	public String findAnAccount(int id) {
		return repo.findAnAccount(id);
		
	}

	
	public String addAccount(String accountNumber) {
		if (accountNumber.contains("9999")) {
			return  "{\"message\": \"This account is blocked\"}";
		}
		return repo.createAccount(accountNumber);
	}


	public String deleteAccount(int id) {
		return repo.deleteAccount(id);
	}










}
