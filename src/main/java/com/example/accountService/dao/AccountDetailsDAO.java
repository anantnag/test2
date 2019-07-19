package com.example.accountService.dao;


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.example.accountService.beans.AccountDetails;
import com.example.accountService.exception.AccountDetailsNotFoundException;

public class AccountDetailsDAO {
	private static Logger logger = Logger.getLogger(AccountDetailsDAO.class.getName());
	static Map<Integer, AccountDetails> accountsMap = new HashMap<Integer, AccountDetails>();

	static {
		accountsMap.put(1, new AccountDetails("Anant", 1));
		accountsMap.put(2, new AccountDetails("Suma", 2));
	}

	public static AccountDetails getAccountDetails(int id) {
		if (accountsMap.containsKey(id)) {
			logger.info("Returning user details");
			return accountsMap.get(id);
		}
		logger.info("Throwing the exception");
		return null;
	}

	public static AccountDetails saveAccountDetails(AccountDetails accountDetails) {

		return accountsMap.put(accountDetails.getAccountID(), accountDetails);
	}
}
