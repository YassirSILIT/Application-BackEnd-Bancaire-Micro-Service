package com.ensak.customerservice1;

import com.ensak.customerservice1.entities.Customer;
import com.ensak.customerservice1.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerService1Application {

	public static void main(String[] args) {
		SpringApplication.run(CustomerService1Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {

			List<Customer> customerList= List.of(
					Customer.builder()
							.firstName("Yassir")
							.lastName("silit")
							.email("yassir.silit@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Ahmed")
							.lastName("souna")
							.email("ahmed.souna@gmail.com")
							.build()
			);
			customerRepository.saveAll(customerList);
		};
	}
}
