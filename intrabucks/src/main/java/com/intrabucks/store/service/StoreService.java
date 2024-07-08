package com.intrabucks.store.service;

import java.util.List;

import com.intrabucks.entity.Store;
import com.intrabucks.store.data.reactdto.Store_StoreDTO;

public interface StoreService {
	public List<Store> getStoreList(); // 전체조회
	public Long editStore(Store_StoreDTO storeDto); // 매장 수정
}
