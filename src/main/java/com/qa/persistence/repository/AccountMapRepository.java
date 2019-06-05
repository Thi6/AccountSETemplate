package com.qa.persistence.repository;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;


public class AccountMapRepository implements AccountRepository{
	


	private Map<Integer, Account> accountMap = new HashMap<Integer, Account>();
	
	//You must provide concrete implementation for each of these methods
	//do not change the method signature
	//THINK - if the parameter is a String, or the return type is a String
	//How can I convert to a String from an Object?
	//What utility methods do I have available?
	
	//You must complete this section using TDD
	//You can use the suggested tests or build your own.

	JSONUtil json = new JSONUtil();
	
	
	public String getAllAccounts() {
		return json.getJSONForObject(accountMap);
	}

	public String createAccount(String account) {
		Account theAccount = json.getObjectForJSON(account, Account.class);
		accountMap.put(theAccount.getId(), theAccount);
		return "Account successfully created.";
	}

	
	
	public String deleteAccount(int id) {
		
		accountMap.remove(id);
		if (accountMap.containsKey(id)) {
			return "Your account has not been deleted";
		} else {
			return  "Your account has been deleted";
		}
		
	}

	public String updateAccount(int id, String account) {
		
		return null;
	}
	
	public Map<Integer, Account> getAccountMap() {
		return accountMap;
	}

	public void setAccountMap(Map<Integer, Account> accountMap) {
		this.accountMap = accountMap;
	}

	public int findByFirstName(String firstName) {
		
		Collection<Account> accountList = accountMap.values();
		int counter = 0;
		
		for (Account anAcc : accountList) {
			if (anAcc.getFirstName().equals(firstName)) {
				counter++;
			}
		}
		
		return counter;
	}

}
