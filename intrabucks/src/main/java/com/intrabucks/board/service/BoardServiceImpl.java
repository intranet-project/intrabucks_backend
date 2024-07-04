package com.intrabucks.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intrabucks.board.data.dto.reactdto.dto.Board_BoardDTO;
import com.intrabucks.entity.Board;


/**
 * 게시판 관리 기능 관련 ServiceImpl로, 
 * 게시판 CRUD 기능 구현
 * @author 김아현
 * @version 1.0
 * 2024-07-04
 **/


@Service
public class BoardServiceImpl implements BoardService{

	@Override
	public Board_BoardDTO createBoard(Board_BoardDTO board_BoardDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board_BoardDTO updateBoard(Long board_id, Board_BoardDTO board_BoardDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> selectBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board_BoardDTO selectOneBoard(Long board_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board_BoardDTO selectBoardOfDepartment(Long dept_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board_BoardDTO searchBoard(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBoard(Long board_id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
