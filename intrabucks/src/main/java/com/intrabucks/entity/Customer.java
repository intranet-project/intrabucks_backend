package com.intrabucks.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 고객 테이블(Customer) 엔티티로, 고객 테이블에 대한 내용을 담고 있음
 * @author 구은재
 * @version 1.0
 * 2024-06-26
 * **/
@Entity
@Table(name = "Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_sequence")
	@SequenceGenerator(name = "cust_sequence", sequenceName = "cust_sequence", allocationSize = 1)
	@Column(name = "cust_id")
	private Long custId; // 고객 ID

    @Column(name = "cust_name")
    private String custName; // 이름

    @Column(name = "cust_password")
    private String custPassword; // 비밀번호

    @Column(name = "cust_email", unique = true)
    private String custEmail; // 이메일

    @Column(name = "cust_phone")
    private String custPhone; // 핸드폰

    @Column(name = "cust_created_at")
    @Temporal(TemporalType.DATE)
    private Date custCreatedAt; // 가입일

    @Column(name = "cust_gender", length = 10)
    private String custGender; // 성별

    @Column(name = "cust_age")
    private Integer custAge; // 나이


}
