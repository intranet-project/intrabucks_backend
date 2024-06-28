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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 고객의 소리 테이블(Voice) 엔티티로, 고객의 소리에 대한정보를 담고 있음
 * @author 최유빈
 * @version 1.0
 * 2024-06-27
 * **/
@Entity
@Table(name = "Voice")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voice {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voice_seq")
	@SequenceGenerator(name = "voice_seq", sequenceName = "voice_seq", allocationSize = 1)
	@Column(name = "voice_id")
    private Integer voiceId; // 고객의 소리 ID
	
	@ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    private Customer customer; // 고객 ID

    @Column(name = "voice_date")
    private Date voiceDate; // 등록일자

    @Column(name = "voice_title")
    private String voiceTitle; // 제목

    @Column(name = "voice_content")
    private String voiceContent; // 내용

    @Column(name = "answer_content")
    private String answerContent; // 답변

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private Store store; // 매장 ID

    @Column(name = "voice_state")
    private String voiceState; // 처리여부

    @Column(name = "answer_date")
    private Date answerDate; // 처리날짜

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee; // 직원 ID

}
