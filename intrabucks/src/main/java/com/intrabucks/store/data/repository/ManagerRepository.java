package com.intrabucks.store.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
	Manager findByStoreId(Long storeId);
	Manager findByEmployeeId(Long employeeId);
}
