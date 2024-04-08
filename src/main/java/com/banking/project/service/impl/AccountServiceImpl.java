package com.banking.project.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.banking.project.dto.AccountDto;
import com.banking.project.entity.Account;
import com.banking.project.mapper.AccountMapper;
import com.banking.project.repository.AccountRespository;
import com.banking.project.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	private AccountRespository accountRespository;
	
	public AccountServiceImpl(AccountRespository accountRespository) {
		this.accountRespository= accountRespository;
	}
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account= AccountMapper.maptoAccount(accountDto);
		Account savedAccount=accountRespository.save(account);
		return AccountMapper.maptoAccountDto(savedAccount);
		
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account=accountRespository.findById(id).orElseThrow(()-> new RuntimeException("Account doesnt found"));
		return AccountMapper.maptoAccountDto(account);
	}

	@Override
	public AccountDto deposite(Long id, double amount) {
		Account account=accountRespository.findById(id).orElseThrow(()-> new RuntimeException("Account doesnt found"));

		double total=account.getBal() + amount;
		account.setBal(total);
		Account Savedaccount2=accountRespository.save(account);
		return AccountMapper.maptoAccountDto(Savedaccount2);
	}

	@Override
	public AccountDto withDraw(Long id, double amount) {
		Account account=accountRespository.findById(id).orElseThrow(()-> new RuntimeException("Account doesnt found"));
		
		if(account.getBal()<amount) {
			throw new RuntimeException("insufficeint foint");
		}
		double total = account.getBal()-amount;
		account.setBal(total);
		Account savedAccount=accountRespository.save(account);
		return AccountMapper.maptoAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<AccountDto> getAllAccounts() {
//		List<Account> accounts= accountRespository.findAll();
//		return accounts.stream().map((account)->AccountMapper.maptoAccountDto(accounts)).collect(Collectors.toList());
//		
//	}

	

}
