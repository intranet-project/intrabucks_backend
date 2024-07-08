package com.intrabucks.menu.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.intrabucks.store.data.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intrabucks.entity.Category;
import com.intrabucks.entity.Employee;
import com.intrabucks.entity.Manager;
import com.intrabucks.entity.Menu;
import com.intrabucks.entity.Stock;
import com.intrabucks.menu.data.reactdto.Menu_MenuDTO;
import com.intrabucks.menu.data.repository.CategoryRepository;
import com.intrabucks.menu.data.repository.MenuRepository;
import com.intrabucks.store.data.reactdto.Manager_ManagerDTO;
import org.springframework.web.client.RestTemplate;

/**
 * @author 최유빈
 * @version 1.1 인트라넷 - 공홈 통신
 * @since 2024-07-08
 * */
@Service
public class MenuServiceImpl implements MenuService {
	private final MenuRepository menuRepository;
	private final CategoryRepository categoryRepository;
	private final RestTemplate restTemplate; // 1.1
	
	@Autowired
	public MenuServiceImpl(MenuRepository menuRepository, CategoryRepository categoryRepository, RestTemplate restTemplate) {
		this.menuRepository = menuRepository;
		this.categoryRepository = categoryRepository;
		this.restTemplate = restTemplate; // 1.1
	}
	
	// 전체조회
	@Override
	public List<Menu> getMenuList() {
		// TODO Auto-generated method stub
		return this.menuRepository.findAll();
	}
	
	// 상세조회
	@Override
	public Menu_MenuDTO selectMenu(Long menuId) throws NoSuchElementException {
		Menu menu = this.menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Menu ID: " + menuId));
		Menu_MenuDTO menuDto = new Menu_MenuDTO();
		menuDto.newMenu(menu);
		return menuDto;
	}
	
	// 메뉴 등록
	@Override
	public Long createMenu(Menu_MenuDTO menuDto) throws NoSuchElementException {
		String categoryName = menuDto.getCategoryName();
		Category category = this.categoryRepository.findByCategoryName(categoryName)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Category Name: " + categoryName));
		
		Menu menu = Menu.builder()
				.menuName(menuDto.getMenuName())
				.category(category)
				.menuPrice(menuDto.getMenuPrice())
				.menuDetail(menuDto.getMenuDetail())
				.menuImg(menuDto.getMenuImg()).build();
		this.menuRepository.save(menu);
		
		return menu.getMenuId();
	}

	// 메뉴 수정
	@Override
	public Long editMenu(Menu_MenuDTO menuDto) throws NoSuchElementException {
		Menu menu = this.menuRepository.findById(menuDto.getMenuId()).orElseThrow();
		
		String categoryName = menuDto.getCategoryName();
		Category category = this.categoryRepository.findByCategoryName(categoryName)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Category Name: " + categoryName));
		
		menu.setMenuName(menuDto.getMenuName());
		menu.setCategory(category);
		menu.setMenuPrice(menuDto.getMenuPrice());
		menu.setMenuDetail(menuDto.getMenuDetail());
		menu.setMenuImg(menuDto.getMenuImg());
		this.menuRepository.save(menu);
  
		return menu.getMenuId();
	}

	// 메뉴 삭제
	@Override
	public String deleteMenu(Long menuId) {
		String result;
		Menu deletedMenu = this.menuRepository.findById(menuId).orElseThrow();
		
		if (deletedMenu != null) {
			this.menuRepository.deleteById(menuId);
			result = "메뉴가 삭제되었습니다.";
		}else {
			result = "메뉴가 존재하지 않습니다.";
		}
		
		return result;
	}
}
