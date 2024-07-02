package com.intrabucks.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 매장 관리자 테이블(Manager) 엔티티로, 매장 관리자에 대한 내용을 담고 있음
 * @author 이정윤
 * @version 1.0
 * 2024-06-27
 * **/

@Builder
@Entity
@Data
@Table(name = "Manager")
@NoArgsConstructor
@AllArgsConstructor
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manager_seq")
	@SequenceGenerator(name = "manager_seq", sequenceName = "manager_seq", allocationSize = 1)
	@Column(name = "manager_id")
	private Long managerId; // 관리자 ID
	
	@Column(name = "manager_name")
    private String managerName; // 관리자 이름

    @Column(name = "manager_password")
    private String managerPassword; // 관리자 비밀번호

    @Column(name = "manager_email")
    private String managerEmail; // 관리자 이메일

    @OneToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private Store store; // 매장 ID

    @Column(name = "manager_created_at")
    @Temporal(TemporalType.DATE)
    private Date managerCreatedAt; // 가입 일자

    @OneToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee; // 직원 ID
}
