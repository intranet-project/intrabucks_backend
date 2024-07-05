package com.intrabucks.store.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intrabucks.employee.data.repository.EmployeeRepository;
import com.intrabucks.entity.Employee;
import com.intrabucks.entity.Manager;
import com.intrabucks.entity.Store;
import com.intrabucks.store.data.dto.ManagerRequestStoreDTO;
import com.intrabucks.store.data.reactdto.Manager_ManagerDTO;
import com.intrabucks.store.data.repository.ManagerRepository;
import com.intrabucks.store.data.repository.StoreRepository;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerRepository managerRepository;
	private StoreRepository storeRepository;
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public ManagerServiceImpl(StoreRepository storeRepository, ManagerRepository managerRepository, EmployeeRepository employeeRepository) {
		this.storeRepository = storeRepository;
		this.managerRepository = managerRepository;
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Manager_ManagerDTO readManager(Long storeId) throws NoSuchElementException {
		// 구현방식: id로 Store를 받아오고 그것을 StoreDTO로 변환
		// 그리고 리턴
		Manager manager = this.managerRepository.findByStoreStoreId(storeId).orElseThrow();
		Manager_ManagerDTO managerDto = new Manager_ManagerDTO();
		managerDto.newManager(manager);
		return managerDto;
	}
	
	@Override
	public Long createStore(ManagerRequestStoreDTO managerStoreDto) throws NoSuchElementException {
		Long id = managerStoreDto.getEmployeeId();
		String name = managerStoreDto.getManagerName();
		String password = managerStoreDto.getManagerPassword();
		String email = managerStoreDto.getManagerEmail();
		Employee employee = this.employeeRepository.findByEmpIdAndEmpNameAndEmpPasswordAndEmpEmail(id, name, password, email).orElseThrow();
		
		Store store = Store.builder()
				.storeName(managerStoreDto.getStoreName())
				.storeAddress(managerStoreDto.getStoreAddress())
				.storeClose(managerStoreDto.getStoreClose()).build();
		this.storeRepository.save(store);
		
		Manager manager = Manager.builder()
				.managerName(name)
				.managerPassword(password)
				.managerEmail(email)
				.store(store)
				.managerCreatedAt(managerStoreDto.getManagerCreatedAt())
				.employee(employee).build();
		this.managerRepository.save(manager);
		// 입력한 값과 Employee 엔티티를 대조하는 방식으로
		return store.getStoreId();
	}

	@Override
	public Long editStore(ManagerRequestStoreDTO managerStoreDto) throws NoSuchElementException {
		Store store = this.storeRepository.findById(managerStoreDto.getStoreId()).orElseThrow();
		store.setStoreName(managerStoreDto.getStoreName());
		store.setStoreAddress(managerStoreDto.getStoreAddress());
		store.setStoreClose(managerStoreDto.getStoreClose());
		this.storeRepository.save(store);
		
		Manager manager = this.managerRepository.findById(managerStoreDto.getManagerId()).orElseThrow();

		Long id = managerStoreDto.getEmployeeId();
		String name = managerStoreDto.getManagerName();
		String password = managerStoreDto.getManagerPassword();
		String email = managerStoreDto.getManagerEmail();
		Employee employee = this.employeeRepository.findByEmpIdAndEmpNameAndEmpPasswordAndEmpEmail(id, name, password, email).orElseThrow();
		
		manager.setManagerName(name);
		manager.setManagerPassword(password);
		manager.setManagerEmail(email);
		manager.setStore(store);
		manager.setManagerCreatedAt(managerStoreDto.getManagerCreatedAt());
		manager.setEmployee(employee);
		this.managerRepository.save(manager);
		
		return store.getStoreId();
	}

}
