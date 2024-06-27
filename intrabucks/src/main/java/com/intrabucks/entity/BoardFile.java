package com.intrabucks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 첨부파일 테이블(BoardFile) 엔티티로, 게시판 입력시 사용할 첨부파일에 관한 내용을 담고 있음
 * @author 김아현
 * @version 1.0 
 * 2024-06-27
 * **/

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BoardFile")
public class BoardFile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_file_seq")
	@SequenceGenerator(name = "board_file_seq", sequenceName = "board_file_seq", allocationSize = 1)
	@Column(name = "board_file_id")
	private Long boardFileId; //첨부파일 ID
	
	@ManyToOne
	@JoinColumn(name = "board_id")
	private Board board; //글 ID
	
	@Column(name = "board_file_org")
	private String boardFileOrg; //파일 원본 이름 (견적서)
	
	@Column(name = "board_file_path")
	private String boardFilePath; //파일경로명 (전체 경로 _ \DATA\견적서.HTML)
	
	@Column(name = "board_file_date")
	private String boardFileDate; //파일 첨부 시간
	
}
