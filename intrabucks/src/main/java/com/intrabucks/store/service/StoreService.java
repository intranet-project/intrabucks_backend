package com.intrabucks.store.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.intrabucks.entity.Store;
import com.intrabucks.store.data.dto.ManagerRequestStoreDTO;
import com.intrabucks.store.data.reactdto.Store_StoreDTO;

public interface StoreService {
	public List<Store> getStoreList(); // 전체조회
}
