package com.intrabucks.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        System.err.println("0000000000000000000000000000000000000000000000000000000000000000000");
    	Stock_StockDTO stockItem = stockService.createStockItem(stock_StockDTO);
        return ResponseEntity.ok(stockItem);
    }
    
    // 재고 item 수정
    @PutMapping("/updateStockItem")
    public ResponseEntity<Stock_StockDTO> updateStockItem(@RequestParam Long stock_id, @RequestParam int count) {
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
    @GetMapping("/selectOneStock")
    public ResponseEntity<Stock_StockDTO> selectOneStock(@RequestParam Long stock_id) {
    	Stock_StockDTO stockItem = stockService.selectOneStock(stock_id);
        if (stockItem != null) {
            return ResponseEntity.ok(stockItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // 재고 Item 삭제 
    @DeleteMapping("/deleteOneStock")
    public ResponseEntity<String> deleteOneStock(@RequestParam Long stock_id) {
    	
    	String result = stockService.deleteOneStock(stock_id);
    	
    	return ResponseEntity.ok(result);
    	
    }
 
}
