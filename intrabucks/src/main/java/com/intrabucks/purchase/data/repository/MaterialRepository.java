package com.intrabucks.purchase.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {

}
