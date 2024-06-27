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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Employee")
@NoArgsConstructor
@AllArgsConstructor

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	@SequenceGenerator(name = "emp_seq", sequenceName = "emp_seq", allocationSize = 1)
	@Column(name = "emp_id")
	private Long empId;
	
	@Column(name = "emp_name")
    private String empName; // 이름

    @Column(name = "emp_password")
    private String empPassword; // 비밀번호

    @Column(name = "emp_email")
    private String empEmail; // 이메일

    @Column(name = "emp_phone")
    private String empPhone; // 핸드폰 번호

    @Column(name = "emp_address")
    private String empAddress; // 주소

    @Column(name = "emp_joindate")
    @Temporal(TemporalType.DATE)
    private Date empJoinDate; // 입사일

    @Column(name = "emp_position")
    private String empPosition; // 직책

    @ManyToOne
    @JoinColumn(name = "dept_code", referencedColumnName = "dept_code")
    private Department department; // 부서 외래 키

    @Column(name = "work_state")
    private String workState; // 재직 상태 (Y/N)
}
