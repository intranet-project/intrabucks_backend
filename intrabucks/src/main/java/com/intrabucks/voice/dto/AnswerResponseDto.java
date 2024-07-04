package com.intrabucks.voice.dto;


import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AnswerResponseDto {
    private Long custId; // 고객ID
    // private String voiceTitle; // 고객의소리 제목
    //private String voiceContent; // 고객의소리 내용
    // private Long storeId; // 매장ID
    private Integer voiceId; // 고객의 소리 ID
    //  private Date voiceDate; // 등록일자
    private String answerContent; // 답변
    private String voiceState; // 처리여부
    private Date answerDate; // 처리날짜
    private Long employee; // 직원 ID

}
