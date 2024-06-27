package com.intrabucks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 메뉴(Menu) 테이블로, 메뉴 정보를 담고 있음
 * @author 최유빈
 * @version 1.0
 * 2024-06-27
 * **/
@Entity
@Table(name = "Menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")
    @SequenceGenerator(name = "menu_seq", sequenceName = "menu_seq", allocationSize = 1)
    @Column(name = "menu_id")
    private Long menuId; // 메뉴 ID
    
    @Column(name = "menu_name", nullable = false, length = 100)
    private String menuName; //메뉴명
    
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category; // 카테고리
    
    @Column(name = "menu_price", nullable = false)
    private Integer menuPrice; // 메뉴 가격
    
    @Column(name = "menu_detail")
    private String menuDetail; // 메뉴 상세
    
    @Column(name = "menu_img")
    private String menuImg; // 메뉴 이미지
}