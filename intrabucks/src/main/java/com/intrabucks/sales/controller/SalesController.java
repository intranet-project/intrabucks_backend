package com.intrabucks.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intrabucks.entity.Sales;
import com.intrabucks.sales.data.reactdto.Sales_SalesDTO;
import com.intrabucks.sales.service.SalesService;
/**
 * @author 최유빈
 * @version 1.1 총매출 조회(Post삭제)
 * @since 2024-07-09
 * **/
@RestController
@RequestMapping("/api/v1/intrabucks/sales")
public class SalesController {
	private final SalesService salesService;
	
	@Autowired
	public SalesController(SalesService salesService) {
		this.salesService = salesService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Sales>> getSalesList() {
		List<Sales> salesList = this.salesService.getSalesList();
		return ResponseEntity.ok(salesList);
	}
	// 1.1
	/*@PostMapping("/create")
	public ResponseEntity<Long> createSales(@RequestBody Sales_SalesDTO salesDto) {
		Long salesId = this.salesService.createSales(salesDto);
		return ResponseEntity.ok().body(salesId);
	}*/
}
