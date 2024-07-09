package com.intrabucks.sales.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.intrabucks.entity.Sales;
import com.intrabucks.sales.data.reactdto.Sales_SalesDTO;
/**
 * @author 최유빈
 * @version 1.1 총매출 조회
 * @since 2024-07-09
 * **/
public interface SalesService {
	public List<Sales> getSalesList(); // 전체조회
	//public Long createSales(Sales_SalesDTO salesDto);// 수정
}
