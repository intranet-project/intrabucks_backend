package com.intrabucks.store.controller;

import com.intrabucks.entity.Store;
import com.intrabucks.entity.Voice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.intrabucks.store.data.dto.ManagerRequestStoreDTO;
import com.intrabucks.store.data.reactdto.Manager_ManagerDTO;
import com.intrabucks.store.data.reactdto.Store_StoreDTO;
import com.intrabucks.store.service.ManagerService;
import com.intrabucks.store.service.StoreService;

import java.util.List;

/**
 * 매장 관리자(Manager) 컨트롤러로, 매장 관리자에 대한 내용을 담고 있음
 * @author 이정윤
 * @version 1.0
 * 2024-07-01
 **/

/**
 * @author 최유빈
 * @version 1.1 인트라넷 - 공홈 통신
 * @since 2024-07-08
 * */

@RestController
@RequestMapping("/api/v1/intrabucks/manager")
public class ManagerController {

	private final ManagerService managerService;

	@Autowired //1.1
	private StoreService storeService;

	@Autowired
	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}

	@GetMapping("/storemanage/read/{id}")
	public ResponseEntity<Manager_ManagerDTO> getManagerByStoreId(@PathVariable("id") Long storeId) {
		Manager_ManagerDTO managerDto = this.managerService.readStore(storeId);
		if (managerDto != null) {
			return ResponseEntity.ok().body(managerDto);
		} else {
			return ResponseEntity.notFound().build();
		}
	} // 매장 상세 조회 (get)

	@PostMapping("/storemanage/create")
	public ResponseEntity<Long> createStore(@RequestBody ManagerRequestStoreDTO managerStoreDto) {
		Long storeId = this.managerService.createStore(managerStoreDto);
		return ResponseEntity.ok().body(storeId);
		// return this.storeService.readStore(storeId);
	} // 매장 등록 (post)

	
	@PutMapping("/storemanage/update/{managerId}")
	public ResponseEntity<Long> updateStore(@RequestBody Manager_ManagerDTO managerDto) {
		Long managerId = this.managerService.editManager(managerDto);
		return ResponseEntity.ok().body(managerId);
	} // 관리자 정보 수정 (put)


	// 1.1
	/* 공홈에 업데이트 된 store정보 제공*/
	@GetMapping("/getstore")
	public List<Store> getStore() {
		return storeService.getStoreList();
	}
}
