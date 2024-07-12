package com.intrabucks.sales.service;

import java.util.ArrayList;
import java.util.List;

import com.intrabucks.entity.Store;
import com.intrabucks.sales.data.reactdto.Sales_SalesDTO;
import com.intrabucks.store.data.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.intrabucks.entity.Sales;
import com.intrabucks.sales.data.repository.SalesRepository;
import org.springframework.web.client.RestTemplate;
/**
 * @author 최유빈
 * @version 1.1 총매출 조회(공홈 서버 통신 - 저장 - 조회 )
 * @since 2024-07-09
 * **/
@Service
public class SalesServiceImpl implements SalesService {
	private final SalesRepository salesRepository;
	private final RestTemplate restTemplate; // 1.1
	private final StoreRepository storeRepository;

	@Autowired
	public SalesServiceImpl(SalesRepository salesRepository, RestTemplate restTemplate, StoreRepository storeRepository) {
		this.salesRepository = salesRepository;
        this.restTemplate = restTemplate; // 1.1
		this.storeRepository = storeRepository;
	}
	
	// 총 매출 내역 // 1.1
	@Override
	public List<Sales> getSalesList() {
		String url = "http://localhost:8000/api/v1/sales";
		ResponseEntity<List<Sales_SalesDTO>> response = restTemplate.exchange(
				url,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Sales_SalesDTO>>() {}
		);

		List<Sales_SalesDTO> salesDTOList = response.getBody();
		List<Sales> salesList = new ArrayList<>();
		for (Sales_SalesDTO dto : salesDTOList) {
			Sales sales = new Sales();
			Store store = this.storeRepository.findById(dto.getStoreId())
					.orElseThrow(() -> new RuntimeException("Store not found"));
			sales.setStore(store);
			sales.setSalesTotalAmount(dto.getSalesAmount());
			sales.setSalesPri(dto.getSalesPri());
			salesList.add(sales);
		}
		salesRepository.saveAll(salesList);
		return salesRepository.findAll();

	}

	// 매출 등록
	/*@Override
	public Long createSales(Sales_SalesDTO salesDto) {
		Store store = salesDto.getStore();

		Sales sales = Sales.builder()
				.store(store)
				.salesTotalAmount(salesDto.getSalesTotalAmount())
				.salesPri(salesDto.getSalesPri()).build();
		this.salesRepository.save(sales);

		return sales.getSalesId();
	}*/
}
