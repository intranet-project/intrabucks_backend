package com.intrabucks.entity;
import java.io.Serializable;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 부서 테이블(Department) 엔티티 : implements Serializable 추가
 * @author 구은재
 * @version 1.0
 * 2024-06-30
 * **/

@Entity
@Table(name = "Department")
@Data
@NoArgsConstructor
public class Department implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
    @SequenceGenerator(name = "dept_seq", sequenceName = "dept_seq", allocationSize = 1)
    @Column(name = "dept_id")
    private Long deptId; // 부서ID

    @Column(name = "dept_code", nullable = false, length = 255)
    private String deptCode; // 부서 코드

    @Column(name = "dept_name", nullable = false, length = 255)
    private String deptName; // 부서명
}