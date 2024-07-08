package com.intrabucks.store.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intrabucks.entity.Store;
import com.intrabucks.store.data.reactdto.Store_StoreDTO;
import com.intrabucks.store.data.repository.StoreRepository;
import org.springframework.web.client.RestTemplate;

/**
 * @author 최유빈
 * @version 1.1 인트라넷 - 공홈 통신
 * @since 2024-07-08
 * */
@Service
public class StoreServiceImpl implements StoreService {

	private final StoreRepository storeRepository;
	private final RestTemplate restTemplate;// 1.1

	@Autowired
	public StoreServiceImpl(StoreRepository storeRepository, RestTemplate restTemplate) {
		this.storeRepository = storeRepository;
		this.restTemplate = restTemplate; // 1.1
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