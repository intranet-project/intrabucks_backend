package com.intrabucks.board.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
