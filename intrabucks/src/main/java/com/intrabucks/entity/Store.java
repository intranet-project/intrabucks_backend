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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 매장 테이블(Store) 엔티티로, 매장에 대한 내용을 담고 있음
 * @author 이정윤
 * @version 1.0
 * 2024-06-27
 * **/

@Builder
@Entity
@Data
@Table(name = "Store")
@NoArgsConstructor
@AllArgsConstructor
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_seq")
	@SequenceGenerator(name = "store_seq", sequenceName = "store_seq", allocationSize = 1)
	@Column(name = "store_id")
	private Long storeId; // 매장 ID
	
	@Column(name = "store_name")
    private String storeName; // 매장 이름

    @Column(name = "store_latitude")
    private Float storeLatitude; // 매장 위도

    @Column(name = "store_longitude")
    private Float storeLongitude; // 매장 경도

    @Column(name = "store_address")
    private String storeAddress; // 매장 주소

    @Column(name = "store_created_at")
    @Temporal(TemporalType.DATE)
    private Date storeCreatedAt; // 매장 등록 일자
    
    @Column(name = "store_close")
    private String storeClose; // 폐점여부
    
}
