package com.intrabucks.customer.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
