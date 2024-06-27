package com.intrabucks.menu.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
