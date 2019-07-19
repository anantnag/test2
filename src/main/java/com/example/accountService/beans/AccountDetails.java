package com.example.accountService.beans;

public class AccountDetails {
	String name;
	int accountID;

	public AccountDetails() {
		
	}
	public AccountDetails(String name, int accountID) {
		this.name = name;
		this.accountID = accountID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
}