package com.intrabucks.quitter.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intrabucks.entity.Quitter;

public interface QuitterRepository extends JpaRepository<Quitter, Long> {

	@Query("SELECT q FROM Quitter q WHERE LOWER(q.quitName) LIKE LOWER(CONCAT('%', :quitName, '%'))")
	Page<Quitter> findByQuitNameContainingIgnoreCase(String quitName, Pageable pageable);

	
	
}
