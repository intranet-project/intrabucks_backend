package com.intrabucks.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intrabucks.entity.Sales;
import com.intrabucks.entity.Store;
import com.intrabucks.sales.data.reactdto.Sales_SalesDTO;
import com.intrabucks.sales.data.repository.SalesRepository;
import com.intrabucks.store.data.repository.StoreRepository;

@Service
public class SalesServiceImpl implements SalesService {
	private final SalesRepository salesRepository;
	
	@Autowired
	public SalesServiceImpl(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}
	
	// 총 매출 내역
	@Override
	public List<Sales> getSalesList() {
		// TODO Auto-generated method stub
		return this.salesRepository.findAll();
	}

	// 매출 등록
	@Override
	public Long createSales(Sales_SalesDTO salesDto) {
		Store store = salesDto.getStore();
		
		Sales sales = Sales.builder()
				.store(store)
				.salesTotalAmount(salesDto.getSalesTotalAmount())
				.salesPri(salesDto.getSalesPri()).build();
		this.salesRepository.save(sales);
		
		return sales.getSalesId();
	}
}
