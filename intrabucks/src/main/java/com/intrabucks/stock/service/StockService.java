package com.intrabucks.stock.service;

import java.util.List;

import com.intrabucks.entity.Stock;
import com.intrabucks.stock.data.reactdto.Stock_StockDTO;


/**
 * 재고 관리 기능 관련 Service로, 
 * 재고 item 추가, 재고 내역 read, 재고 item 삭제, 재고 수량 수정 등의 기능을 구현
 * @author 김아현
 * @version 1.0
 * 2024-06-28
 * **/

public interface StockService {

	//재고 item 생성
	Stock_StockDTO createStockItem(Stock_StockDTO stock_StockDTO);
	
	//재고 수량 update
	Stock_StockDTO updateStockItem(Long stock_id, int count);
	
	//재고 내역 확인
	List<Stock> selectStockList();

	//재고 item 고르기
	Stock_StockDTO selectOneStock(Long stockId);
	
	//재고 item 삭제 
	String deleteOneStock(Long stock_id);
}
