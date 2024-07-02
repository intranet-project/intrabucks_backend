package com.intrabucks.voice.service;

import com.intrabucks.entity.Voice;

import java.util.List;

public interface VoiceService {
    public String getVoice(int voiceId);

    List<Voice> selectAllVoice();
}
