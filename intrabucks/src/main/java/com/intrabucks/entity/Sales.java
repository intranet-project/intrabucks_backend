package com.intrabucks.entity;
import java.math.BigDecimal;
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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 매출 테이블(Sales) 엔티티로, 주문건에 대한 매출 정보를 담고 있음
 * @author 최유빈
 * @version 1.0
 * 2024-06-27
 * **/

@Builder
@Entity
@Table(name = "Sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_seq")
    @SequenceGenerator(name = "sales_seq", sequenceName = "sales_seq", allocationSize = 1)
    @Column(name = "sales_id")
    private Long salesId; //매출 ID
    
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store; // 매장 ID
   
    @Column(name = "sales_total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal salesTotalAmount; // 매출 금액
   
    @Column(name = "sales_pri", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date salesPri; // 매출 기간
}