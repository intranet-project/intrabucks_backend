package com.intrabucks.sales.data.reactdto;

import java.math.BigDecimal;
import java.util.Date;

import com.intrabucks.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sales_SalesDTO {
	
    private Long salesId; // 매출 ID
    
    private Store store; // 매장 ID

    private BigDecimal salesTotalAmount; // 매출 금액
   
    private Date salesPri; // 매출 기간
    
}
