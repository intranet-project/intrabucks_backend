package com.intrabucks.menu.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
