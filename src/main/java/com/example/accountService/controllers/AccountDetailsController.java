package com.example.accountService.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.accountService.beans.AccountDetails;
import com.example.accountService.dao.AccountDetailsDAO;
import com.example.accountService.exception.AccountDetailsNotFoundException;

@RestController
public class AccountDetailsController {

	@GetMapping(path="/account-details/{id}")
	public AccountDetails accountDetails(@PathVariable int id) throws AccountDetailsNotFoundException{
		
		AccountDetails  accountDetails = AccountDetailsDAO.getAccountDetails(id);
		if (accountDetails == null) {
			throw new AccountDetailsNotFoundException("accountNotfound for " + id);
		}
		return accountDetails;
			
	}
	
	@PostMapping(path="/account-details/")
	public ResponseEntity<Object> addAccountDetails(@RequestBody AccountDetails accountDetails) {
		AccountDetailsDAO.saveAccountDetails(accountDetails);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
						buildAndExpand(accountDetails.getAccountID()).toUri();
		
		return ResponseEntity.created(location).build();

	}
}
