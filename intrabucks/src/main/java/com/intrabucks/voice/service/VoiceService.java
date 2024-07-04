package com.intrabucks.voice.service;

import com.intrabucks.entity.Voice;
import com.intrabucks.voice.dto.AnswerRequestDto;

import java.util.List;

public interface VoiceService {
    public String getVoice(int voiceId);
    List<Voice> selectAllVoice();
    String saveAnswer(AnswerRequestDto voice);// 답변 저장
    Voice getAnswer(int voiceId);
}
