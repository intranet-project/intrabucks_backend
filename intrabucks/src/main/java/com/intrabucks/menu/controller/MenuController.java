package com.intrabucks.menu.controller;

import java.util.List;

import com.intrabucks.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intrabucks.entity.Menu;
import com.intrabucks.menu.data.reactdto.Menu_MenuDTO;
import com.intrabucks.menu.service.MenuService;
import com.intrabucks.store.data.reactdto.Manager_ManagerDTO;

@RestController
@RequestMapping("/api/v1/intrabucks/menu")
public class MenuController {
	private final MenuService menuService;
	
	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Menu>> getMenuList() {
		List<Menu> menuList = this.menuService.getMenuList();
		return ResponseEntity.ok(menuList);
	} // 전체조회
	
	@GetMapping("/read/{id}")
	public ResponseEntity<Menu_MenuDTO> getOneMenu(@PathVariable("id") Long menuId) {
		Menu_MenuDTO menuDto = this.menuService.selectMenu(menuId);
		if (menuDto != null) {
			return ResponseEntity.ok().body(menuDto);
		} else {
			return ResponseEntity.notFound().build();
		}
	} // 상세 조회
	
	@PostMapping("/create")
	public ResponseEntity<Long> createMenu(@RequestBody Menu_MenuDTO menuDto) {
		Long menuId = this.menuService.createMenu(menuDto);
		return ResponseEntity.ok().body(menuId);
	} // 메뉴 등록
	
	@PutMapping("/update/{menuId}")
	public ResponseEntity<Long> updateMenu(@RequestBody Menu_MenuDTO menuDto) {
		Long menuId = this.menuService.editMenu(menuDto);
		return ResponseEntity.ok().body(menuId);
	} // 메뉴 수정
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable("id") Long menuId) {
    	
    	String result = this.menuService.deleteMenu(menuId);
    	
    	return ResponseEntity.ok(result);
    	
    } // 메뉴 삭제

	// 1.1
	/* 공홈에 업데이트 된 메뉴정보 제공*/
	@GetMapping("/getmenu")
	public List<Menu> getMenu() {
		return menuService.getMenuList();
	}
}
