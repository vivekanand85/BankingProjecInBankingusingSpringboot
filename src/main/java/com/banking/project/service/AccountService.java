package com.banking.project.service;

import java.util.List;

import com.banking.project.dto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto accountDto);
	
	AccountDto getAccountById(Long id);
	
	AccountDto deposite(Long id, double amount);
	
	AccountDto withDraw(Long id, double amount);
	
	List<AccountDto> getAllAccounts();
	
 
}
