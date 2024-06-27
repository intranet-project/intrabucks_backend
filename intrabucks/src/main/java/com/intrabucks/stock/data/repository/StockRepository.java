package com.intrabucks.stock.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
