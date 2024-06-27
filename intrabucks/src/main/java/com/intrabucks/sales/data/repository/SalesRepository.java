package com.intrabucks.sales.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {

}
