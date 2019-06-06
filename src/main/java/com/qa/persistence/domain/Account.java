package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	//This class needs to have:
	//An id
	//An Account Number
	//A First Name
	//A last Name
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length = 100)
	private String accountNumber;
	@Column(length = 100)
	private String firstName;
	@Column(length = 100)
	private String lastName;
	
	public Account() {
		
	}
	
	public Account(int id, String accountNumber, String firstName, String lastName) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
