package com.intrabucks.stock.data.reactdto;

import com.intrabucks.entity.Material;
import com.intrabucks.entity.Store;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 인트라넷에서 리액트로 API 사용을 목적으로 DTO 생성
 * @author 김아현
 * 2024.06.28
 * **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock_StockDTO {

	private Long stockId; // 재고 ID
    
	private Material material; // 원자재 ID

    private Integer stockCount; // 재고수량

    private Store store; // 매장 ID

}
