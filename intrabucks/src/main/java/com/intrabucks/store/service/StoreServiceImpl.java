package com.intrabucks.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intrabucks.entity.Stock;
import com.intrabucks.entity.Store;
import com.intrabucks.stock.data.reactdto.Stock_StockDTO;
import com.intrabucks.store.data.reactdto.Store_StoreDTO;
import com.intrabucks.store.data.repository.ManagerRepository;
import com.intrabucks.store.data.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {

	private final StoreRepository storeRepository;

	@Autowired
	public StoreServiceImpl(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}

	@Override
	public List<Store> getStoreList() {
		// TODO Auto-generated method stub
		return this.storeRepository.findAll();
	}

	@Override
	public Long editStore(Store_StoreDTO storeDto) {
		Store store = this.storeRepository.findById(storeDto.getStoreId()).orElseThrow();
		store.setStoreName(storeDto.getStoreName());
		store.setStoreAddress(storeDto.getStoreAddress());
		store.setStoreClose(storeDto.getStoreClose());
		store.setStoreCreatedAt(storeDto.getStoreCreatedAt());
		this.storeRepository.save(store);
		
		return store.getStoreId();
	}

}