package com.intrabucks.entity;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
/**
 * 발주 테이블(Purchase) 엔티티로, 발주서에 대한 내용을 담고 있음
 * @author 원치호
 * @version 1.0
 * 2024-06-27
 * **/
@Entity
@Table(name = "Purchase")
@Data
@NoArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchase_seq")
    @SequenceGenerator(name = "purchase_seq", sequenceName = "purchase_seq", allocationSize = 1)
    @Column(name = "purchase_id")
    private Long purchaseId; // 발주 ID
    
    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "manager_id")
    private Manager manager; // 지점관리자 ID FK
    
    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "material_id")
    private Material material; // 원자재 ID FK
    
    @Column(name = "purchase_count", nullable = false)
    private Integer purchaseCount; // 발주 수량
    
    @Column(name = "purchase_require_date", nullable = false)
    private Date purchaseRequireDate; // 발주 요청 날짜
    
    @Column(name = "purchase_accept_date", nullable = true)
    private Date purchaseAcceptDate; // 발주 승인 날짜
    
    @Column(name = "purchase_state", nullable = true, length = 20)
    private String purchaseState; // 발주 상태
    
    @Column(name = "purchase_totalprice", nullable = true)
    private Double purchaseTotalPrice; // 총 가격
    
}