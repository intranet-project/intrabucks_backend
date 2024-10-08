package com.intrabucks.menu.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Optional<Category> findByCategoryName(String categoryName);
}
