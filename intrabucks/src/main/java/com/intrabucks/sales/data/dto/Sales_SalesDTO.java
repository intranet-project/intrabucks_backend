package com.intrabucks.sales.data.dto;

import java.util.Date;

import com.intrabucks.entity.Sales;
import com.intrabucks.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sales_SalesDTO {
	private Long salesId; // 매출 ID
	
	private Store store; // 매장 이름

    private String storeAddress; // 매장 주소
    
    private Date salesPri; // 폐점여부
    
    public Sales_SalesDTO newStore(Sales sales) {
    	this.storeId = store.getStoreId();
		this.storeName = store.getStoreName();
		this.storeAddress = store.getStoreAddress();
		this.storeClose = store.getStoreClose();
		return this;
	}
}
