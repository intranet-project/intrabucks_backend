package com.intrabucks.store.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
