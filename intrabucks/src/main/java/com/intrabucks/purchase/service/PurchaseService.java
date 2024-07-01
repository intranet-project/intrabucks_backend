package com.intrabucks.purchase.service;

import java.util.List;

import com.intrabucks.entity.Purchase;
import com.intrabucks.purchase.data.reactdto.Purchase_PurchaseDTO;

public interface PurchaseService {

	//재고 item 생성
	Purchase_PurchaseDTO createPurchaseItem(Purchase_PurchaseDTO purchase_PurchaseDTO);
	
	//재고 수량 update
	Purchase_PurchaseDTO updatePurchaseItem(Purchase_PurchaseDTO purchase_PurchaseDTO);
	
	//재고 내역 확인
	List<Purchase> selectPurchaseList();

	//재고 item 고르기
	Purchase_PurchaseDTO selectOneselectPurchaseList(Long purchase_id);
	
	//재고 item 삭제 
	String deleteOnePurchase(Long purchase_id);
}
