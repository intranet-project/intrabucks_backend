package com.intrabucks.quitter.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Quitter;

public interface QuitterRepository extends JpaRepository<Quitter, Long> {

}
