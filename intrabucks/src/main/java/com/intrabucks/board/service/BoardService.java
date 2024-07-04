package com.intrabucks.board.service;

import java.util.List;

import com.intrabucks.board.data.dto.reactdto.dto.Board_BoardDTO;
import com.intrabucks.entity.Board;

/**
 * 게시판 관리 기능 관련 Service로, 
 * 게시판 CRUD 기능 구현
 * @author 김아현
 * @version 1.0
 * 2024-07-04
 **/


public interface BoardService {
	
	//게시판 작성
	Board_BoardDTO createBoard(Board_BoardDTO board_BoardDTO);
	
	//게시판 수정
	Board_BoardDTO updateBoard(Long board_id, Board_BoardDTO board_BoardDTO);
	
	//게시판 전체 조회
	List<Board> selectBoardList();
	
	//게시판 하나만 조회
	Board_BoardDTO selectOneBoard(Long board_id);

	//게시판 부서별 리스트 조회     
	Board_BoardDTO selectBoardOfDepartment(Long dept_id);

	//게시판 제목 검색
	Board_BoardDTO searchBoard(String keyword);
	
	//게시판 삭제 
	String deleteBoard(Long board_id);
	   
	}



