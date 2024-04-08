  package com.banking.project.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.project.dto.AccountDto;
import com.banking.project.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService=accountService;
	}
	//add account REST api
	
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAcccountById(@PathVariable Long id){
		AccountDto accountDto= accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	}
	
//deposite rest api
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
			@RequestBody Map<String, Double> request){
		AccountDto accountDto= accountService.deposite(id, request.get("amount"));
		return ResponseEntity.ok(accountDto);
	}
	
	//withdraw REST api
	
	@PutMapping("/{id}/withdraw")
  public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double >request ){
	
	  double amount = request.get("amount");
	  AccountDto accountDto= accountService.withDraw(id, amount);
	  
	  return ResponseEntity.ok(accountDto);
	  
	  
	
}
}