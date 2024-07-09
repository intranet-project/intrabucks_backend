package com.intrabucks.sales.data.reactdto;

import java.math.BigDecimal;
import java.util.Date;

import com.intrabucks.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @author 최유빈
 * @version 1.1 Store store -> 매장Id 변경
 * @since 2024-07-09
 * **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sales_SalesDTO {
	
    private Long salesId; // 매출 ID
    
    private Long storeId; // 매장 ID // 1.1

    private BigDecimal salesAmount; // 매출 금액
   
    private Date salesPri; // 매출 기간
    
}
