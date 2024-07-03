package com.intrabucks.store.service;

import java.util.NoSuchElementException;

import com.intrabucks.store.data.dto.ManagerRequestStoreDTO;
import com.intrabucks.store.data.reactdto.Manager_ManagerDTO;

public interface ManagerService {
	public Manager_ManagerDTO readManager(Long storeId) throws NoSuchElementException;// 상세조회
	public Long createStore(ManagerRequestStoreDTO managerStoreDto) throws NoSuchElementException; // 등록
	public Long editStore(ManagerRequestStoreDTO managerStoreDto) throws NoSuchElementException;// 수정
}
