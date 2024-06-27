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
	private Long stockId;
	
	@ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "material_id")
    private Material material; 

    @Column(name = "stock_count")
    private Integer stockCount; 

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private Store store; 

}
