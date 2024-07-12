package com.intrabucks.store.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
   PasswordEncoder passwordEncoder;
   
   @Autowired
   public ManagerServiceImpl(StoreRepository storeRepository, ManagerRepository managerRepository, EmployeeRepository employeeRepository) {
      this.storeRepository = storeRepository;
      this.managerRepository = managerRepository;
      this.employeeRepository = employeeRepository;
   }
   
   @Override
   public Manager_ManagerDTO readStore(Long storeId) throws NoSuchElementException {
      
      Manager manager = this.managerRepository.findByStoreStoreId(storeId).orElseThrow(); // entity 받기
      // 혹시 사원정보 바뀌었을 경우 교체
      Employee emp = manager.getEmployee();
      manager.setManagerName(emp.getEmpName());
      manager.setManagerPassword(passwordEncoder.encode(emp.getEmpPassword()));
      manager.setManagerEmail(emp.getEmpEmail());
      this.managerRepository.save(manager);
      Manager_ManagerDTO managerDto = new Manager_ManagerDTO();
      managerDto.newManager(manager);
      return managerDto;
   }
   
   @Override
   public Long createStore(ManagerRequestStoreDTO managerStoreDto) throws NoSuchElementException {
      String name = managerStoreDto.getManagerName();
      String password = passwordEncoder.encode(managerStoreDto.getManagerPassword());
      String email = managerStoreDto.getManagerEmail();
      Employee employee = this.employeeRepository.findByEmpEmail(email);
      
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
   public Long editManager(Manager_ManagerDTO managerDto) throws NoSuchElementException {
      Store store = managerDto.getStore();
      
      Manager manager = this.managerRepository.findById(managerDto.getManagerId()).orElseThrow();

      String name = managerDto.getManagerName();
      String password = passwordEncoder.encode(managerDto.getManagerPassword());
      String email = managerDto.getManagerEmail();
      Employee employee = this.employeeRepository.findByEmpEmail(email);
      
      manager.setManagerName(name);
      manager.setManagerPassword(password);
      manager.setManagerEmail(email);
      manager.setStore(store);
      manager.setManagerCreatedAt(managerDto.getManagerCreatedAt());
      manager.setEmployee(employee);
      this.managerRepository.save(manager);
      
      return manager.getManagerId();
   }

}