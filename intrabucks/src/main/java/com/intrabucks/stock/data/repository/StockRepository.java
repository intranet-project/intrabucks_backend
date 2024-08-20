package com.intrabucks.stock.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

	//자재명 검색
	List<Stock> findByMaterialMaterialNameContaining(String keyword);

	//매장명 검색
	List<Stock> findByStoreStoreNameContaining(String keyword);

}
