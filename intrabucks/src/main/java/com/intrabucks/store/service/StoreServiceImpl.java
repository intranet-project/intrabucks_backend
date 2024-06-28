package com.intrabucks.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intrabucks.entity.Store;
import com.intrabucks.store.data.dto.StoreDTO;
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
	public StoreDTO readStore(Long id) {
		// TODO Auto-generated method stub
		
		return null;
	}
	

	@Override
	public StoreDTO regStore(StoreDTO storeDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoreDTO editStore(Store store) {
		// TODO Auto-generated method stub
		return null;
	}

}
