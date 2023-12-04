package com.ensak.accountservice1.repository;

import com.ensak.accountservice1.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
