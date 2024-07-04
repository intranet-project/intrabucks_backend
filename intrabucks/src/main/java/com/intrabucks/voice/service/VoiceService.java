package com.intrabucks.voice.service;

import com.intrabucks.entity.Voice;
import com.intrabucks.voice.dto.AnswerRequestDto;

import java.util.List;

public interface VoiceService {
    public String getVoice();
    List<Voice> selectAllVoice();
    String saveAnswer(AnswerRequestDto answer);// 답변 저장
    List<Voice> getAnswer(long custId);
}
