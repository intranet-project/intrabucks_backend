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
    private Integer voiceId;
	
	@ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    private Customer customer;

    @Column(name = "voice_date")
    private Date voiceDate;

    @Column(name = "voice_title")
    private String voiceTitle;

    @Column(name = "voice_content")
    private String voiceContent;

    @Column(name = "answer_content")
    private String answerContent;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private Store store;

    @Column(name = "voice_state")
    private String voiceState;

    @Column(name = "answer_date")
    private Date answerDate;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee;

}
