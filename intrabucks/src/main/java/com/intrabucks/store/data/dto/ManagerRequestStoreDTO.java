package com.intrabucks.store.data.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ManagerRequestStoreDTO {
	private Long storeId; // 매장 ID
	
	private String storeName; // 매장 이름

    private String storeAddress; // 매장 주소
    
    private String storeClose; // 폐점여부
    // 매장의 column
	private Long employeeId; // 직원 ID
	// 직원의 column
	
    private Long managerId; // 관리자 ID
	
	private String managerName; // 관리자 이름
	
	private String managerPassword; // 관리자 비밀번호
	
	private String managerEmail; // 관리자 이메일
	
	private Date managerCreatedAt; // 가입 일자
    
}
