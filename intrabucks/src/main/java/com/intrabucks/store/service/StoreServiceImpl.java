package com.intrabucks.store.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intrabucks.entity.Store;
import com.intrabucks.store.data.dto.Store_StoreDTO;
import com.intrabucks.store.data.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;
	
	@Override
	public List<Store> getStoreList() {
		// TODO Auto-generated method stub
		return this.storeRepository.findAll();
	}
	
	@Override
	public Store_StoreDTO readStore(Long id) throws NoSuchElementException {
		// 구현방식: id로 Store를 받아오고 그것을 StoreDTO로 변환
		// 그리고 리턴
		Store store = this.storeRepository.findById(id).orElseThrow();
		Store_StoreDTO storeDto = new Store_StoreDTO();
		storeDto.newStore(store);
		return storeDto;
	}
	

	@Override
	public Long regStore(Store_StoreDTO storeDto) {
		Store store = Store.builder()
				.storeName(storeDto.getStoreName())
				.storeAddress(storeDto.getStoreAddress())
				.storeCreatedAt(storeDto.getStoreCreatedAt())
				.storeClose(storeDto.getStoreClose()).build();
		this.storeRepository.save(store);
		return store.getStoreId();
	}

	@Override
	public Store_StoreDTO editStore(Store store) {
		// TODO Auto-generated method stub
		return null;
	}

}
