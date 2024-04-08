package com.banking.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.project.entity.Account;

public interface AccountRespository extends JpaRepository<Account, Long> {

}
