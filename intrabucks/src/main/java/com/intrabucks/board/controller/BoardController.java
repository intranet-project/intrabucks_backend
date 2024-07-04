package com.intrabucks.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intrabucks.board.data.dto.reactdto.dto.Board_BoardDTO;
import com.intrabucks.board.service.BoardService;
import com.intrabucks.entity.Board;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * 게시판 관리 기능 관련 Controller로, 
 * 게시판 CRUD 기능 구현
 * @author 김아현
 * @version 1.0
 * 2024-07-04
 **/

@RestController
@RequestMapping("/api/v1/intrabucks/board")
public class BoardController {
   
   @Autowired
   private BoardService boardService;
   
   //게시판 작성
   @PostMapping("/createBoard")
   public ResponseEntity<Board_BoardDTO> createBoard(@RequestBody Board_BoardDTO board_BoardDTO){
	   Board_BoardDTO board = boardService.createBoard(board_BoardDTO);
	   return ResponseEntity.ok(board);
   }
   
   //게시판 수정
   @PutMapping("/updateBoard/{board_id}")
   public ResponseEntity<Board_BoardDTO> updateBoard(@PathVariable Long board_id, @RequestBody Board_BoardDTO board_BoardDTO){
	   Board_BoardDTO board = boardService.updateBoard(board_id, board_BoardDTO);			   
	   return ResponseEntity.ok(board);
   }
   
   //게시판 전체 조회
   @GetMapping("/selectBoardList")
   public ResponseEntity<List<Board>> selectBoardList(){
	  List<Board> board = boardService.selectBoardList();			   
	  return ResponseEntity.ok(board);
   }
   
   //게시판 하나만 조회
   @PostMapping("/selectOneBoard/{board_id}")
   public ResponseEntity<Board_BoardDTO> selectOneBoard(@PathVariable Long board_id){
	   Board_BoardDTO board = boardService.selectOneBoard(board_id);   
	   return ResponseEntity.ok(board);
   }
   
   //게시판 부서별 리스트 조회   
   @PostMapping("/selectBoardOfDepartment/{dept_id}")
   public ResponseEntity<Board_BoardDTO> selectBoardOfDepartment(@PathVariable Long dept_id){
	   Board_BoardDTO board = boardService.selectBoardOfDepartment(dept_id);
	   return ResponseEntity.ok(board);
   }
   
   //게시판 제목 검색
   @PostMapping("/searchBoard/{keyword}")
   public ResponseEntity<Board_BoardDTO> searchBoard(@PathVariable String keyword){
	   Board_BoardDTO board = boardService.searchBoard(keyword);
	   return ResponseEntity.ok(board);
   }
   
   //게시판 삭제 
   @DeleteMapping("/deleteBoard/{board_id}")
   public ResponseEntity<String> deleteBoard(@PathVariable Long board_id){
	   String result = boardService.deleteBoard(board_id);
	   return ResponseEntity.ok(result);
   }
   
   //첨부파일 업로드
   

   

}
