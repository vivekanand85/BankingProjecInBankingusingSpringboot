package com.banking.project.mapper;

import com.banking.project.dto.AccountDto;
import com.banking.project.entity.Account;

public class AccountMapper {

public static Account maptoAccount(AccountDto accountDto) {
	Account account=new Account(
    accountDto.getId(),
    accountDto.getAccno(),
    accountDto.getBalance()
	);
	return account;
	
}

public static AccountDto maptoAccountDto(Account account) {
	AccountDto accountDto = new AccountDto(
	account.getId(),
	account.getAccno(),
	account.getBal()
	);
	return accountDto;
}


}