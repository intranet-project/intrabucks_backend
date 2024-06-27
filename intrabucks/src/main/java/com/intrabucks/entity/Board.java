package com.intrabucks.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 게시판 테이블(Board) 엔티티로, 게시판 글에 대한 내용을 담고 있음
 * @author 김아현
 * @version 1.0 
 * 2024-06-27
 * **/

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq")
	@SequenceGenerator(name = "board_seq", sequenceName = "board_seq", allocationSize = 1)
	@Column(name = "board_id")
	private Long boardId; //글 ID
	
	@Column(name = "board_title")
	private String boardTitle; //글 제목
	
	@Column(name = "board_content")
	private String boardContent; //글 내용
	
	@ManyToOne
	@JoinColumn(name = "emp_email")
	private Employee employee; //작성자 이메일 FK
	
	@Column(name = "board_date")
	private Date boardDate; //게시일자
	
	@Column(name = "board_file")
	private String boardFile; //첨부파일
	
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department department; //부서 FK
	

}
