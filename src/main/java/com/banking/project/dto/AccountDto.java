package com.banking.project.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class AccountDto {

	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDto(Long id, String accno, double balance) {
		super();
		this.id = id;
		this.accno = accno;
		this.balance = balance;
	}
	private String accno;
	private double balance;
}
