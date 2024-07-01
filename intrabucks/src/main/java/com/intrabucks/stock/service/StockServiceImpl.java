package com.intrabucks.stock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intrabucks.entity.Stock;
import com.intrabucks.stock.data.reactdto.Stock_StockDTO;
import com.intrabucks.stock.data.repository.StockRepository;



@Service
public class StockServiceImpl implements StockService{
	private StockRepository stockRepository;
	
	@Autowired
	public StockServiceImpl(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	//재고 내역 생성
	@Override
	public Stock_StockDTO createStockItem(Stock_StockDTO stock_StockDTO) {
		//DTO 객체 엔티티로 변경
		Stock addStock = new Stock();
		
		//addStock.setStockId(stock_StockDTO.getStockId());
		addStock.setStockCount(stock_StockDTO.getStockCount());
		addStock.setStore(stock_StockDTO.getStore());
		addStock.setMaterial(stock_StockDTO.getMaterial());
		
		//레포지터리 적용
		Stock stock = stockRepository.save(addStock);

		//엔티티 객체 DTO로 변경
		Stock_StockDTO addStockDTO = new Stock_StockDTO();
		//addStockDTO.setStockId(stock.getStockId());
		addStockDTO.setStockCount(stock.getStockCount());
		addStockDTO.setStore(stock.getStore());
		addStockDTO.setMaterial(stock.getMaterial());
		
		return addStockDTO;
	}
	
	//재고 수량 업데이트
	@Override
	public Stock_StockDTO updateStockItem(Long stock_id, int count) {
		//해당 재고 조회
		Optional<Stock> existStock = stockRepository.findById(stock_id);
		
		//객체 선언
		Stock updateStock = new Stock();
		Stock_StockDTO updateStockDTO = new Stock_StockDTO();
		
		//해당 재고에 대한 정보가 있다면, 해당 재고의 재고량 업데이트
		if (existStock.isPresent()) {
		
			updateStock = existStock.get();
			//재고 업데이트
			updateStock.setStockCount(count);
			
			//레포지터리 적용
			Stock stock = stockRepository.save(updateStock);

			//엔티티 객체 DTO로 변경
			//updateStockDTO.setStockId(stock.getStockId());
			updateStockDTO.setStockCount(stock.getStockCount());
			updateStockDTO.setStore(stock.getStore());
			updateStockDTO.setMaterial(stock.getMaterial());
			
		}
		
		
		return updateStockDTO;
	}

	
	//재고 전체 내역 불러오기
	@Override
	public List<Stock> selectStockList() {
		List<Stock> stockList = stockRepository.findAll();
		return stockList;
	}

	//재고 내역 1개 조회
	@Override
	public Stock_StockDTO selectOneStock(Long stock_id) {
		
		
		Stock selectOneStock = stockRepository.getById(stock_id);
		
		Stock_StockDTO stockOneItem = new Stock_StockDTO();
		
		//stockOneItem.setStockId(selectOneStock.getStockId());
		stockOneItem.setStockCount(selectOneStock.getStockCount());
		stockOneItem.setStore(selectOneStock.getStore());
		stockOneItem.setMaterial(selectOneStock.getMaterial());
		
		return stockOneItem;
	}

	@Override
	public String deleteOneStock(Long stock_id) {
		
		String result;
		//유효성 
		Stock deleteOneStock = stockRepository.getById(stock_id);
		
		if (deleteOneStock != null) {
			stockRepository.deleteById(stock_id);
			result = "상품이 삭제되었습니다";
		}else {
			result = "상품이 삭제과정에서 문제가 발생했습니다.";
		}
		
		return result;
	}
	
	
	
	

}
