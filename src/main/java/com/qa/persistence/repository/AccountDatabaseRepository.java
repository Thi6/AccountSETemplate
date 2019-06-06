package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;

import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class AccountDatabaseRepository implements AccountRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	JSONUtil json = new JSONUtil();
	
	public String getAllAccounts() {
		TypedQuery<Account> query = manager.createQuery("SELECT a FROM Account a", Account.class);
		Collection<Account> accounts = query.getResultList();
		return json.getJSONForObject(accounts);
	}
	
	public String findAnAccount(int id) {
		Account anAccount = manager.find(Account.class, id);
		return json.getJSONForObject(anAccount);
	}
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account theAccount = json.getObjectForJSON(account, Account.class);
		manager.persist(theAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}
	@Transactional(REQUIRED)
	public String deleteAccount(int accountNumber) {
		Account anAccount = manager.find(Account.class, accountNumber);
		manager.remove(anAccount);
		return "{\"message\": \"account has been sucessfully deleted\"}";
	}
	@Transactional(REQUIRED)
	public String updateAccount(int accountNumber, String account) {
		
		return null;
	}

}
