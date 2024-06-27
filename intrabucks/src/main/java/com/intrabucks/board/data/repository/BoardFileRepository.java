package com.intrabucks.board.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.BoardFile;

public interface BoardFileRepository extends JpaRepository<BoardFile, Long> {

}
