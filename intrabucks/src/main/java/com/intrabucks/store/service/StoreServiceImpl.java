package com.intrabucks.store.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intrabucks.entity.Manager;
import com.intrabucks.entity.Store;
import com.intrabucks.store.data.dto.ManagerRequestStoreDTO;
import com.intrabucks.store.data.reactdto.Manager_ManagerDTO;
import com.intrabucks.store.data.reactdto.Store_StoreDTO;
import com.intrabucks.store.data.repository.ManagerRepository;
import com.intrabucks.store.data.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {

	private final StoreRepository storeRepository;
	private final ManagerRepository managerRepository;
	
	@Autowired
	public StoreServiceImpl(StoreRepository storeRepository, ManagerRepository managerRepository) {
		this.storeRepository = storeRepository;
		this.managerRepository = managerRepository;
	}
	
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
	public Long regStore(ManagerRequestStoreDTO managerStoreDto) {
		Store store = Store.builder()
				.storeId(managerStoreDto.getStoreId())
				.storeName(managerStoreDto.getStoreName())
				.storeAddress(managerStoreDto.getStoreAddress())
				.storeClose(managerStoreDto.getStoreClose()).build();
		this.storeRepository.save(store);
		Manager_ManagerDTO managerDto = managerStoreDto.getManagerDto();
		Manager manager = Manager.builder()
				.managerId(managerDto.getManagerId())
				.managerName(managerDto.getManagerName())
				.managerPassword(managerDto.getManagerPassword())
				.managerEmail(managerDto.getManagerEmail())
				.store(store)
				.managerCreatedAt(managerDto.getManagerCreatedAt())
				.employee(managerDto.getEmployee()).build();
		this.managerRepository.save(manager);
		return store.getStoreId();
	}

	@Override
	public Long editStore(Store_StoreDTO storeDto) {
		// TODO Auto-generated method stub
		Store store = this.storeRepository.findById(storeDto.getStoreId()).orElseThrow();
		store.setStoreName(storeDto.getStoreName());
		store.setStoreAddress(storeDto.getStoreAddress());
		store.setStoreClose(storeDto.getStoreClose());
		this.storeRepository.save(store);
		return store.getStoreId();
	}

}
