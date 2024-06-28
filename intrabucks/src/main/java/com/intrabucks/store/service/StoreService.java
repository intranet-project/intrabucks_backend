package com.intrabucks.store.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.intrabucks.entity.Store;
import com.intrabucks.store.data.dto.StoreDTO;

public interface StoreService {
	public List<Store> getStoreList(); // 전체조회
	public StoreDTO readStore(Long id) throws NoSuchElementException ;// 상세조회
	public Long regStore(StoreDTO storeDto); // 등록
	public StoreDTO editStore(Store store);// 수정
}
