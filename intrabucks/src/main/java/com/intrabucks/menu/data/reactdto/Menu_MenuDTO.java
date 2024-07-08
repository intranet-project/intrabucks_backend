package com.intrabucks.menu.data.reactdto;

import com.intrabucks.entity.Menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Menu_MenuDTO {
	
    private Long menuId; // 메뉴 ID
    
    private String menuName; // 메뉴명
    
    private String categoryName; // 카테고리명

    private Integer menuPrice; // 가격
   
    private String menuDetail; // 메뉴상세
    
    private String menuImg; // 메뉴이미지
    
    public Menu_MenuDTO newMenu(Menu menu) {
    	this.menuId = menu.getMenuId();
		this.menuName = menu.getMenuName();
		this.categoryName = menu.getCategory().getCategoryName();
		this.menuPrice = menu.getMenuPrice();
		this.menuDetail = menu.getMenuDetail();
		this.menuImg = menu.getMenuImg();
		return this;
	}
    
}
