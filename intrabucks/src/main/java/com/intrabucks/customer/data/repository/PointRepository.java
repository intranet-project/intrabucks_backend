package com.intrabucks.customer.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Point;

public interface PointRepository extends JpaRepository<Point, Long> {

}
