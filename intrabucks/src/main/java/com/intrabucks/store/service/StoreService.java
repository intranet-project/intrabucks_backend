package com.intrabucks.store.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.intrabucks.entity.Store;
import com.intrabucks.store.data.dto.ManagerRequestStoreDTO;
import com.intrabucks.store.data.reactdto.Store_StoreDTO;

public interface StoreService {
	public List<Store> getStoreList(); // 전체조회
	public Store_StoreDTO readStore(Long id) throws NoSuchElementException ;// 상세조회
	public Long regStore(ManagerRequestStoreDTO managerStoreDto); // 등록
	public Long editStore(Store_StoreDTO storeDto);// 수정
}
