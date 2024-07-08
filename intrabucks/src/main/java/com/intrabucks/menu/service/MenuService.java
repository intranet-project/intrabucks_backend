package com.intrabucks.menu.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.intrabucks.entity.Menu;
import com.intrabucks.menu.data.reactdto.Menu_MenuDTO;
import com.intrabucks.store.data.reactdto.Manager_ManagerDTO;

public interface MenuService {
	public List<Menu> getMenuList(); // 전체조회
	public Menu_MenuDTO selectMenu(Long menuId) throws NoSuchElementException; // 상세조회
	public Long createMenu(Menu_MenuDTO menuDto) throws NoSuchElementException;// 등록
	public Long editMenu(Menu_MenuDTO menuDto) throws NoSuchElementException;// 수정
	public String deleteMenu(Long menuId); // 삭제
}
