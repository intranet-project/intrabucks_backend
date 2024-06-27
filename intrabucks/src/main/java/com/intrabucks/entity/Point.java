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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 포인트 테이블(Point) 엔티티로, 선불카드 결제시 사용할 포인트에 관한 내용을 담고 있음
 * @author 김아현
 * @version 1.0 
 * 2024-06-27
 * **/

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Point")
public class Point {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_id_seq")
	@SequenceGenerator(name = "point_id_seq", sequenceName = "point_id_seq", allocationSize = 1)
	@Column(name = "point_id")
	private Long pointId; //포인트 고유 ID
	
	@OneToOne
	@JoinColumn(name = "cust_id")
	private Customer custId; //사용자 고유 ID
	
	@Column(name = "point_usable")
	private Long pointUsable; //사용가능 한 포인트
	
	@Column(name = "point_created_at")
	private Date pointCreatedAt; //포인트 충전 일자
	
	@Column(name = "point_update_at")
	private Date pointUpdateAt; //포인트 사용 일자
 
}
