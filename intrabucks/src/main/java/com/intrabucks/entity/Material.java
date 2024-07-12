package com.intrabucks.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 원자재 테이블(Material) 엔티티 : 원자재 관련 정보, 원자재 거래처 정보 
 * @author 원치호
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Table(name = "Material")
@Data
@NoArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_seq")
    @SequenceGenerator(name = "material_seq", sequenceName = "material_seq", allocationSize = 1)
    @Column(name = "material_id")
    private Long materialId; // 원자재 ID

    @Column(name = "material_name", nullable = false, length = 20)
    private String materialName; // 원자재명

    @Column(name = "material_company", nullable = false, length = 20)
    private String materialCompany; // 거래처

    @Column(name = "material_companyCode", nullable = false, length = 20)
    private String materialCompanyCode; // 거래처 코드

    @Column(name = "material_manager", nullable = false, length = 20)
    private String materialManager; // 담당자명

    @Column(name = "material_contact", nullable = false)
    private String materialContact; // 연락처

    @Column(name = "material_price", nullable = false)
    private Double materialPrice; // 원가
}