package com.ensak.accountservice1;

import com.ensak.accountservice1.clients.CustomerRestClient;
import com.ensak.accountservice1.entities.BankAccount;
import com.ensak.accountservice1.enums.AccountType;
import com.ensak.accountservice1.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountService1Application {

	public static void main(String[] args) {
		SpringApplication.run(AccountService1Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository accountRepository,
										CustomerRestClient customerRestClient){
		return args -> {
			customerRestClient.allCustomers().forEach(c -> {
				BankAccount bankAccount1 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(Math.random()*7000)
						.createAt(LocalDate.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(c.getId())
						.build();
				BankAccount bankAccount2 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(Math.random()*6544)
						.createAt(LocalDate.now())
						.type(AccountType.SAVING_ACCOUNT)
						.customerId(c.getId())
						.build();
				accountRepository.save(bankAccount1);
				accountRepository.save(bankAccount2);
			});
		};
	}
}
