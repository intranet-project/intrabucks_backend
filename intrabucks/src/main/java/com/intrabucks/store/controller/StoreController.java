package com.intrabucks.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intrabucks.entity.Store;
import com.intrabucks.store.data.dto.Store_StoreDTO;
import com.intrabucks.store.service.StoreService;
/**
 * 매장 관리 기능(Store) 컨트롤러로, 매장에 대한 내용을 담고 있음
 * @author 이정윤
 * @version 1.0
 * 2024-06-28
 * **/
@RestController
@RequestMapping("/api/v1/intrabucks/store")
public class StoreController {
	
	private final StoreService storeService;
	
	@Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }
	
	@GetMapping("/list")
	public List<Store> getStoreList() {
		List<Store> storeList = this.storeService.getStoreList();
		return storeList;
	} // 매장 내역 (get)
	
	@GetMapping("/read/{id}")
	public Store_StoreDTO getStoreById(@PathVariable("id") Long id) {
		Store_StoreDTO storeDto = this.storeService.readStore(id);
		return storeDto;
	} // 매장 상세 조회 (get)
	
	@PostMapping("/create")
	public Store_StoreDTO create(Store_StoreDTO storeDto) {
		Long storeId = this.storeService.regStore(storeDto);
		return this.storeService.readStore(storeId);
	} // 매장 등록 (post)
	
	/*
	 * @PutMapping("/update/{id}") public StoreDTO update(@PathVariable("id")
	 * Integer id) { Integer storeId = this.storeService.update(); } // 매장 정보 수정
	 * (put)
	 */}
