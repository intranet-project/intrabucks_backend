package com.intrabucks.store.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
	Optional<Manager> findByStoreStoreId(Long storeId);
	Optional<Manager> findByEmployeeEmpId(Long empId);
}
