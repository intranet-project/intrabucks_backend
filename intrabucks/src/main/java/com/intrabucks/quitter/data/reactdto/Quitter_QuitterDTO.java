package com.intrabucks.quitter.data.reactdto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

/**
 * 퇴사자(Quitter)의 DTO
 * @author 구은재
 * @version 1.0 
 * 2024-06-30
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quitter_QuitterDTO {

	private Long quitId; // 퇴사자 ID
    private String quitName; // 이름
    private String quitEmail; // 이메일
    private String quitPhone; // 핸드폰 번호
    private String quitAddress; // 주소
    private Date quitJoindate; // 입사일
    private String quitPosition; // 직책
    private Date quitLeavingdate; // 퇴사일
    private String deptCode; // 부서 코드
	
}
