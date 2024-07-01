package com.intrabucks.store.data.dto;

import com.intrabucks.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store_StoreDTO {
	private Long storeId; // 매장 ID
	
	private String storeName; // 매장 이름

    private String storeAddress; // 매장 주소
    
    private String storeClose; // 폐점여부
    
    public Store_StoreDTO newStore(Store store) {
    	this.storeId = store.getStoreId();
		this.storeName = store.getStoreName();
		this.storeAddress = store.getStoreAddress();
		this.storeClose = store.getStoreClose();
		return this;
	}
}
