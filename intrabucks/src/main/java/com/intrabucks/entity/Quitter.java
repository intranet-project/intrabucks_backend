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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * 퇴사자 테이블(Quitter) 엔티티로, 퇴사자에 관한 내용을 담고 있음
 * @author 이정윤
 * @version 1.0 
 * 2024-06-27
 * **/

@Entity
@Table(name = "Quitter")
@Data
public class Quitter {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quit_seq")
	@SequenceGenerator(name = "quit_seq", sequenceName = "quit_seq", allocationSize = 1)
	@Column(name = "quit_id")
	private Long quitId; // 퇴사자 ID
	
	@Column(name = "quit_name")
    private String quitName; // 이름

    @Column(name = "quit_email")
    private String quitEmail; // 이메일
    
    @Column(name = "quit_phone")
    private String quitPhone; // 핸드폰 번호

    @Column(name = "quit_address")
    private String quitAddress; // 주소
	
	@Column(name = "quit_joindate")
	@Temporal(TemporalType.DATE)
	private Date quitJoindate; // 입사일
	
	@Column(name = "quit_position")
	private String quitPosition; // 직책
	
	@Column(name = "quit_leavingdate")
	@Temporal(TemporalType.DATE)
	private Date quitLeavingdate; // 퇴사일
	
	@ManyToOne
    @JoinColumn(name = "dept_code", referencedColumnName = "dept_code")
    private Department department; // 부서 코드
	
}
