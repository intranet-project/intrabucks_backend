package com.intrabucks.entity;

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
 * 재고 테이블(Stock) 엔티티로, 재고 테이블에 대한 내용을 담고 있음
 * @author 구은재
 * @version 1.0
 * 2024-06-26
 * **/
@Entity
@Data
@Table(name = "Stock")
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_seq")
	@SequenceGenerator(name = "stock_seq", sequenceName = "stock_seq", allocationSize = 1)
	@Column(name = "stock_id")
	private Long stockId; // 재고 ID
	
	@ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "material_id")
    private Material material; // 원자재 ID

    @Column(name = "stock_count")
    private Integer stockCount; // 재고수량

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private Store store; // 매장 ID

}
