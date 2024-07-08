package com.intrabucks.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.*;
/**
 * 카테고리 테이블(Category) 엔티티로, 메뉴에 대한 카테고리 내용을 담고 있음
 * @author 최유빈
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Table(name = "Category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize = 1)
    @Column(name = "category_id")
    private Long categoryId; // 카테고리ID

    @Column(name = "category_name", nullable = false)
    private String categoryName; // 카테고리명

    }