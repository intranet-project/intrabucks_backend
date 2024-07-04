package com.intrabucks.purchase.controller;

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

import com.intrabucks.entity.Purchase;
import com.intrabucks.purchase.data.reactdto.Purchase_PurchaseDTO;
import com.intrabucks.purchase.service.PurchaseService;



/**
 * 발주 관리 기능 관련 Controller로, 
 * 발주 item 추가, 발주 내역 read, 발주 item 삭제, 발주 수량 수정 등의 기능을 구현
 * @version 1.0
 * 2024-06-28
 **/

@CrossOrigin(origins  = "http://localhost:3001")
@RestController
@RequestMapping(value = "/api/v1/intrabucks/purchase")
public class PurchaseController {

	private final PurchaseService purchaseService;
	
	@Autowired
	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	 
    // 발주 item 생성
    @PostMapping("/createPurchaseItem")
    public ResponseEntity<Purchase_PurchaseDTO> createPurchaseItem(@RequestBody Purchase_PurchaseDTO purchase_PurchaseDTO) {
    	Purchase_PurchaseDTO purchaseItem = purchaseService.createPurchaseItem(purchase_PurchaseDTO);
        return ResponseEntity.ok(purchaseItem);
    }
    
    // 발주 item 수정
    @PutMapping("/updatePurchaseItem/{purchase_id}")
    public ResponseEntity<Purchase_PurchaseDTO> updatePurchaseItem(@PathVariable Long purchase_id, @RequestBody Purchase_PurchaseDTO purchase_PurchaseDTO) {
    	
    	Purchase_PurchaseDTO purchaseItem = purchaseService.updatePurchaseItem(purchase_PurchaseDTO);
        if (purchaseItem != null) {
            return ResponseEntity.ok(purchaseItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // 발주 리스트 조회
    @GetMapping("/selectPurchaseList")
    public ResponseEntity<List<Purchase>> selectPurchaseList() {
        List<Purchase> purchaseList = purchaseService.selectPurchaseList();
        return ResponseEntity.ok(purchaseList);
    }
    
    // 발주 Item 조회 
    @GetMapping("/selectOnePurchase/{purchase_id}")
    public ResponseEntity<Purchase_PurchaseDTO> selectOnePurchase(@PathVariable Long purchase_id) {
    	Purchase_PurchaseDTO purchaseItem = purchaseService.selectOneselectPurchaseList(purchase_id);
        if (purchaseItem != null) {
            return ResponseEntity.ok(purchaseItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // 발주 Item 삭제 
    @DeleteMapping("/deleteOnePurchase/{purchase_id}")
    public ResponseEntity<String> deleteOneStock(@PathVariable Long purchase_id) {
    	
    	String result = purchaseService.deleteOnePurchase(purchase_id);
    	
    	return ResponseEntity.ok(result);
    	
    }
 
	
}
