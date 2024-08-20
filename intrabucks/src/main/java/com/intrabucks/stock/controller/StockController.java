package com.intrabucks.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.intrabucks.entity.Stock;
import com.intrabucks.stock.data.reactdto.Stock_StockDTO;
import com.intrabucks.stock.service.StockService;

/**
 * 재고 관리 기능 관련 Controller로, 
 * 재고 item 추가, 재고 내역 read, 재고 item 삭제, 재고 수량 수정 등의 기능을 구현
 * @version 1.0
 * 2024-06-28
 **/


@RestController
@RequestMapping(value = "/api/v1/intrabucks/stock")
public class StockController {
    
    private final StockService stockService;
    
    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    
    // 재고 item 생성
    @PostMapping("/createStockItem")
    public ResponseEntity<Stock_StockDTO> createStockItem(@RequestBody Stock_StockDTO stock_StockDTO) {
    	Stock_StockDTO stockItem = stockService.createStockItem(stock_StockDTO);
        return ResponseEntity.ok(stockItem);
    }
    
    // 재고 item 수정
    @PutMapping("/updateStockItem/{stock_id}/{count}")
    public ResponseEntity<Stock_StockDTO> updateStockItem(@PathVariable Long stock_id, @PathVariable int count) {
        Stock_StockDTO stockItem = stockService.updateStockItem(stock_id, count);
        if (stockItem != null) {
            return ResponseEntity.ok(stockItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // 재고 리스트 조회
    @GetMapping("/selectStockList")
    public ResponseEntity<List<Stock>> selectStockList() {
        List<Stock> stockList = stockService.selectStockList();
        return ResponseEntity.ok(stockList);
    }
    
    // 재고 Item 조회
    @GetMapping("/selectOneStock/{stock_id}")
    public ResponseEntity<Stock_StockDTO> selectOneStock(@PathVariable Long stock_id) {
    	Stock_StockDTO stockItem = stockService.selectOneStock(stock_id);
        if (stockItem != null) {
            return ResponseEntity.ok(stockItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // 재고 Item 삭제 
    @DeleteMapping("/deleteOneStock/{stock_id}")
    public ResponseEntity<String> deleteOneStock(@PathVariable Long stock_id) {
    	
    	String result = stockService.deleteOneStock(stock_id);
    	
    	return ResponseEntity.ok(result);
    	
    }
 
    //재고명 검색하기
    @GetMapping("/selectStockListByProduct/{keyword}")
    public ResponseEntity<List<Stock>> selectStockListByProduct(@PathVariable String keyword){
    	List<Stock> selectList = stockService.selectStockListByProduct(keyword);
		return ResponseEntity.ok(selectList);
    }
    
    //매장명 검색하기
    @GetMapping("/selectStockListByStore/{keyword}")
    public ResponseEntity<List<Stock>> selectStockListByStore(@PathVariable String keyword){
    	List<Stock> selectList = stockService.selectStockListByStore(keyword);
		return ResponseEntity.ok(selectList);
    }
   
    //엑셀 다운로드
    
}
