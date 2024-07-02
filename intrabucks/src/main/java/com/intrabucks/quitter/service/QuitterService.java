package com.intrabucks.quitter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.intrabucks.entity.Employee;
import com.intrabucks.quitter.data.reactdto.Quitter_QuitterDTO;

/**
 * 퇴사자(Quitter)의 Service : CRUD
 * @author 구은재
 * @version 1.0 
 * 2024-06-30
 **/

public interface QuitterService {

	public Long createQuitter(Quitter_QuitterDTO quitterDTO) throws IllegalArgumentException; // 퇴사자등록
	Page<Quitter_QuitterDTO> ListQuitter(String quitName, Pageable pageable); // 퇴사자 전체 조회
	public Quitter_QuitterDTO selectOneQuitter(Long quitId); // 퇴사자 ID 정보 조회
	public Long updateQuitter(Quitter_QuitterDTO quitterDTO); // 퇴사자 정보 수정
	public Long deleteQuitter(Long quitId); // 퇴사자 정보 삭제
}
