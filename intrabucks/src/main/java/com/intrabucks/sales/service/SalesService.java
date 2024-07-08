package com.intrabucks.sales.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.intrabucks.entity.Sales;
import com.intrabucks.sales.data.reactdto.Sales_SalesDTO;

public interface SalesService {
	public List<Sales> getSalesList(); // 전체조회
	public Long createSales(Sales_SalesDTO salesDto);// 수정
}
