package com.qa.MapTests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;



public class AccountServiceTest {
	private AccountMapRepository amr;
	private JSONUtil json;
	private Account myAccount;
	private Account myAccount2;
	private Account myAccount3;
	@Before
	public void setup() {
		amr = new AccountMapRepository();
		json = new JSONUtil();
		myAccount = new Account(1, "1", "Matt", "Hunt");
		myAccount2 = new Account(2, "2", "Jane", "Fern");
		myAccount3 = new Account(3, "3", "Matt", "Harris");
	}
	
	@Ignore
	@Test
	public void addAccountTest() {
		
		String myAccString = json.getJSONForObject(myAccount);
		System.out.println(myAccString);
		// JSON string {"id":1,"accountNumber":"1","firstName":"Matt","lastName":"Hunt"}
		assertEquals("Account successfully created.", amr.createAccount(myAccString));
		

		assertEquals(true, amr.getAccountMap().containsKey(1));

		
	}
	@Ignore
	@Test
	public void add2AccountsTest() {
		fail("TODO");	
	}
	@Ignore
	@Test
	public void removeAccountTest() {
		
		assertEquals("Your account has been deleted", amr.deleteAccount(myAccount.getId()));
		assertEquals(false, amr.getAccountMap().containsKey(1));
	}
	@Ignore
	@Test
	public void remove2AccountsTest() {
		fail("TODO");	
	}
	

	@Ignore
	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		fail("TODO");	
	}
	@Ignore
	@Test
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil
		fail("TODO");	
	}

	@Ignore
	@Test
	public void accountConversionToJSONTest() {
		//testing JSONUtil
		fail("TODO");	
	}

	
	@Ignore
	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		amr.getAccountMap().put(1, myAccount);
		amr.getAccountMap().put(2, myAccount2);
		
		int counter = amr.findByFirstName("hello");
		
		assertEquals(0, counter);
	}
	
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		amr.getAccountMap().put(1, myAccount);
		amr.getAccountMap().put(2, myAccount2);
		
		int counter = amr.findByFirstName("Matt");
		
		assertEquals(1, counter);
		
	}

	@Test 
	public void getCountForFirstNamesInAccountWhenTwo() {
		amr.getAccountMap().put(1, myAccount);
		amr.getAccountMap().put(2, myAccount2);
		amr.getAccountMap().put(3, myAccount3);
		
		int counter = amr.findByFirstName("Matt");
		
		assertEquals(2, counter);
	}

}
