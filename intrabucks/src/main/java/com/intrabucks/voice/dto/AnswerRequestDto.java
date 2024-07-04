package com.intrabucks.voice.dto;


import lombok.*;

import java.util.Date;
/**
 * AnswerRequestDto로 리액트로 부터 받음
 * @author 최유빈
 * @version 1.2
 * 2024-07-04
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AnswerRequestDto {
    //private Long custId; // 고객ID
   // private String voiceTitle; // 고객의소리 제목
    //private String voiceContent; // 고객의소리 내용
   // private Long storeId; // 매장ID
    private Integer voiceId; // 고객의 소리 ID
  //  private Date voiceDate; // 등록일자
    private String answerContent; // 답변
    private Long employee; // 직원 ID

}
