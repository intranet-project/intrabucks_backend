package com.intrabucks.store.data.reactdto;

import java.util.Date;

import com.intrabucks.entity.Employee;
import com.intrabucks.entity.Manager;
import com.intrabucks.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager_ManagerDTO {
	private Long managerId; // 관리자 ID
	
	private String managerName; // 관리자 이름
	
	private String managerPassword; // 관리자 비밀번호
	
	private String managerEmail; // 관리자 이메일

	private Store store; // 매장 ID
	
	private Date managerCreatedAt; // 가입 일자
    
	private Employee employee; // 직원 ID
    
    public Manager_ManagerDTO newManager(Manager manager) {
    	this.managerId = manager.getManagerId();
		this.managerName = manager.getManagerName();
		this.managerPassword = manager.getManagerPassword();
		this.managerEmail = manager.getManagerEmail();
		this.store = manager.getStore();
		this.managerCreatedAt = manager.getManagerCreatedAt();
		this.employee = manager.getEmployee();
		return this;
	}
}
