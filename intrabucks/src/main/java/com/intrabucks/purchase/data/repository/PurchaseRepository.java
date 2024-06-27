package com.intrabucks.purchase.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
