package com.intrabucks.store.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intrabucks.entity.Store;
import com.intrabucks.quitter.data.reactdto.Quitter_QuitterDTO;
import com.intrabucks.store.data.dto.ManagerRequestStoreDTO;
import com.intrabucks.store.data.reactdto.Store_StoreDTO;
import com.intrabucks.store.service.StoreService;

/**
 * 매장 관리 기능(Store) 컨트롤러로, 매장에 대한 내용을 담고 있음
 * @author 이정윤
 * @version 1.0
 * 2024-06-28
 **/

@RestController
@RequestMapping("/api/v1/intrabucks/store")
public class StoreController {

	private final StoreService storeService;

	@Autowired
	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}

	@GetMapping("/list")
	public ResponseEntity<List<Store>> getStoreList() {
		List<Store> storeList = this.storeService.getStoreList();
		return ResponseEntity.ok().body(storeList);
//		return storeList;
	} // 매장 내역 (get)
	
	@PutMapping("/update/{storeId}")
	public ResponseEntity<Long> updateStore(@RequestBody Store_StoreDTO storeDto) {
		Long storeId = this.storeService.editStore(storeDto);
            return ResponseEntity.ok().body(storeId);
	} // 매장 정보 수정 (put)
}
