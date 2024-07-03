package com.intrabucks.purchase.data.reactdto;

import java.util.Date;

import com.intrabucks.entity.Manager;
import com.intrabucks.entity.Material;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Purchase 기능 인트라넷에서 리액트로 API 사용을 목적으로 DTO 생성
 * @author 김아현
 * 2024.06.28
 * **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase_PurchaseDTO {

	    private Long purchaseId; // 발주 ID
	    
	    private Manager manager; // 지점관리자 ID FK
	    
	    private Material material; // 원자재 ID FK
	   
	    private Integer purchaseCount; // 발주 수량
	    
	    private Date purchaseRequireDate; // 발주 요청 날짜
	    
	    private Date purchaseAcceptDate; // 발주 승인 날짜
	    
	    private String purchaseState; // 발주 상태
	
	    //private Double purchasePrice; // 
	 
	    private Double purchaseTotalPrice; // 총 가격
}
