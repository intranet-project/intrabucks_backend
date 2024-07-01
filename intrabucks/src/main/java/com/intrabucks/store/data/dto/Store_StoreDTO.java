package com.intrabucks.store.data.dto;

import java.util.Date;

import com.intrabucks.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store_StoreDTO {
	private String storeName; // 매장 이름

    private String storeAddress; // 매장 주소

    private Date storeCreatedAt; // 매장 등록 일자
    
    private String storeClose; // 폐점여부
    
    public Store_StoreDTO newStore(Store store) {
		this.storeName = store.getStoreName();
		this.storeAddress = store.getStoreAddress();
		this.storeCreatedAt = store.getStoreCreatedAt();
		this.storeClose = store.getStoreClose();
		return this;
	}
}
