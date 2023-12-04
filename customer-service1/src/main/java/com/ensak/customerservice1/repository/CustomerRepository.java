package com.ensak.customerservice1.repository;

import com.ensak.customerservice1.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
