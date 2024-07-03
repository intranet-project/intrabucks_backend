package com.intrabucks.sales.data.reactdto;

import java.math.BigDecimal;
import java.util.Date;

import com.intrabucks.entity.Sales;
import com.intrabucks.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sales_SalesDTO {
	
    private Long salesId; // 매출 ID
    
    private Long storeId; // 매장 ID

    private BigDecimal salesTotalAmount; // 매출 금액
   
    private Date salesPri; // 매출 기간
    
    public Sales_SalesDTO newSales(Sales sales) {
    	this.salesId = sales.getSalesId();
		this.storeId = sales.getStore().getStoreId();
		this.salesTotalAmount = sales.getSalesTotalAmount();
		this.salesPri = sales.getSalesPri();
		return this;
	}
}
