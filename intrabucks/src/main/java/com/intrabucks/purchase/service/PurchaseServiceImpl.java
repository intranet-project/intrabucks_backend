package com.intrabucks.purchase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intrabucks.entity.Material;
import com.intrabucks.entity.Purchase;
import com.intrabucks.purchase.data.reactdto.Purchase_PurchaseDTO;
import com.intrabucks.purchase.data.repository.MaterialRepository;
import com.intrabucks.purchase.data.repository.PurchaseRepository;

/**
 * 발주 관리 기능 관련 Service로, 
 * 발주 item 추가, 발주 내역 read, 발주 item 삭제, 발주 수량 수정 등의 기능을 구현
 * @version 1.0
 * 2024-06-28
 **/

@Service
public class PurchaseServiceImpl implements PurchaseService{
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private MaterialRepository materialRepository;

	//발주 내역 생성
	@Override
	public Purchase_PurchaseDTO createPurchaseItem(Purchase_PurchaseDTO purchase_PurchaseDTO) {
		//DTO 객체 엔티티로 변경
		Purchase addPurchase = new Purchase();
		
		//가격 처리
		Double price = 0.0;
		if (purchase_PurchaseDTO.getMaterial() != null) {
			Material material = materialRepository.getById(purchase_PurchaseDTO.getMaterial().getMaterialId());
		
			if (material != null) {
				price = material.getMaterialPrice();
			}else{
				System.out.println("material이 null이라 오류 발생");
			}
				
		}
		
		//상태 처리
		String state = null;
		if (purchase_PurchaseDTO.getPurchaseRequireDate() != null && purchase_PurchaseDTO.getPurchaseAcceptDate() == null) {
			state = "처리중";
		}else if (purchase_PurchaseDTO.getPurchaseRequireDate() != null && purchase_PurchaseDTO.getPurchaseAcceptDate() != null) {
			state = "처리완료";
		}
		
		addPurchase.setManager(purchase_PurchaseDTO.getManager());
		addPurchase.setMaterial(purchase_PurchaseDTO.getMaterial());
		addPurchase.setPurchaseAcceptDate(purchase_PurchaseDTO.getPurchaseAcceptDate());;
		addPurchase.setPurchaseCount(purchase_PurchaseDTO.getPurchaseCount());
		addPurchase.setPurchaseId(purchase_PurchaseDTO.getPurchaseId());
		addPurchase.setPurchaseRequireDate(purchase_PurchaseDTO.getPurchaseRequireDate());
		addPurchase.setPurchaseState(state);
		addPurchase.setPurchaseTotalPrice(price * purchase_PurchaseDTO.getPurchaseCount());
		
		//레포지터리 적용
		Purchase purchase = purchaseRepository.save(addPurchase);
		
		//엔티티 객체 DTO로 변경
		Purchase_PurchaseDTO addPurchaseDTO = new Purchase_PurchaseDTO();
		
		addPurchaseDTO.setManager(purchase.getManager());
		addPurchaseDTO.setMaterial(purchase.getMaterial());
		addPurchaseDTO.setPurchaseAcceptDate(purchase.getPurchaseAcceptDate());
		addPurchaseDTO.setPurchaseCount(purchase.getPurchaseCount());
		addPurchaseDTO.setPurchaseId(purchase.getPurchaseId());
		addPurchaseDTO.setPurchaseRequireDate(purchase.getPurchaseRequireDate());
	
		
		return addPurchaseDTO;
	}

	//발주 수량 업데이트
	@Override
	public Purchase_PurchaseDTO updatePurchaseItem(Purchase_PurchaseDTO purchase_PurchaseDTO) {
		
		//가격 처리
		Double price = 0.0;
		if (purchase_PurchaseDTO.getMaterial() != null) {
			Material material = materialRepository.getById(purchase_PurchaseDTO.getMaterial().getMaterialId());
		
			if (material != null) {
				price = material.getMaterialPrice();
			}else{
				System.out.println("material이 null이라 오류 발생");
			}
				
		}
				
		//상태 처리
		String state = null;
		if (purchase_PurchaseDTO.getPurchaseRequireDate() != null && purchase_PurchaseDTO.getPurchaseAcceptDate() == null) {
			state = "처리중";
		}else if (purchase_PurchaseDTO.getPurchaseRequireDate() != null && purchase_PurchaseDTO.getPurchaseAcceptDate() != null) {
			state = "처리완료";
		}
				
		
		//해당 발주 정보 조회
		Optional<Purchase> existPurchase = purchaseRepository.findById(purchase_PurchaseDTO.getPurchaseId());

		//객체 선언
		Purchase updatePurchase = new Purchase();
		Purchase_PurchaseDTO updatePurchaseDTO = new Purchase_PurchaseDTO();
		
		//해당 발주에 대한 정보가 있다면, 해당 발주의 정보 업데이트
		if (existPurchase.isPresent()) {
			
			updatePurchase = existPurchase.get();
			//발주 업데이트 
			updatePurchase.setManager(purchase_PurchaseDTO.getManager());
			updatePurchase.setMaterial(purchase_PurchaseDTO.getMaterial());
			updatePurchase.setPurchaseAcceptDate(purchase_PurchaseDTO.getPurchaseAcceptDate());
			updatePurchase.setPurchaseCount(purchase_PurchaseDTO.getPurchaseCount());
			updatePurchase.setPurchaseId(purchase_PurchaseDTO.getPurchaseId());
			updatePurchase.setPurchaseRequireDate(purchase_PurchaseDTO.getPurchaseRequireDate());
			updatePurchase.setPurchaseState(state);
			updatePurchase.setPurchaseTotalPrice(price * purchase_PurchaseDTO.getPurchaseCount());
			
			//레포지터리 적용
			Purchase purchase = purchaseRepository.save(updatePurchase);
			
			//엔티티 객체 DTO로 변경
			updatePurchaseDTO.setManager(purchase.getManager());
			updatePurchaseDTO.setMaterial(purchase.getMaterial());
			updatePurchaseDTO.setPurchaseAcceptDate(purchase.getPurchaseAcceptDate());
			updatePurchaseDTO.setPurchaseCount(purchase.getPurchaseCount());
			updatePurchaseDTO.setPurchaseId(purchase.getPurchaseId());
			updatePurchaseDTO.setPurchaseRequireDate(purchase.getPurchaseRequireDate());
			updatePurchaseDTO.setPurchaseState(state);
			updatePurchaseDTO.setPurchaseTotalPrice(price);
			}
		
		
		return updatePurchaseDTO;
	}

	//발주 전체 내역 불러오기
	@Override
	public List<Purchase> selectPurchaseList() {
		//발주 전체 내역 불러오기
		List<Purchase> purchaseList = purchaseRepository.findAll();
		
		return purchaseList;
	}

	//발주 내역 1개 조회하기
	@Override
	public Purchase_PurchaseDTO selectOneselectPurchaseList(Long purchase_id) {
	
		//해당 내역 1개 조회
		Purchase selectOnePurchasse = purchaseRepository.getById(purchase_id);
		
		//객체 선언
		Purchase_PurchaseDTO purchaseOneItem = new Purchase_PurchaseDTO();
		
		//엔티티 객체 DTO로 변경
		purchaseOneItem.setManager(selectOnePurchasse.getManager());
		purchaseOneItem.setMaterial(selectOnePurchasse.getMaterial());
		purchaseOneItem.setPurchaseAcceptDate(selectOnePurchasse.getPurchaseAcceptDate());
		purchaseOneItem.setPurchaseCount(selectOnePurchasse.getPurchaseCount());
		purchaseOneItem.setPurchaseId(selectOnePurchasse.getPurchaseId());
		purchaseOneItem.setPurchaseRequireDate(selectOnePurchasse.getPurchaseRequireDate());
		purchaseOneItem.setPurchaseState(selectOnePurchasse.getPurchaseState());
		purchaseOneItem.setPurchaseTotalPrice(selectOnePurchasse.getPurchaseTotalPrice());
		
		return purchaseOneItem;
	}

	//발주 삭제하기
	@Override
	public String deleteOnePurchase(Long purchase_id) {
		String result;
		
		//유효성 
		Purchase deleteOnePurchase = purchaseRepository.getById(purchase_id);
		
		if (deleteOnePurchase != null) {
			//발주 내역 삭제
			purchaseRepository.deleteById(purchase_id);
			result = "발주 내역이 삭제되었습니다";
		}else {
			result = "발주내역 삭제과정에서 문제가 발생했습니다.";
		}
		return result;
	}

}
