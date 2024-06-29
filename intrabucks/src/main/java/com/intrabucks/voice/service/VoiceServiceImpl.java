package com.intrabucks.voice.service;

import com.intrabucks.voice.dto.voiceResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VoiceServiceImpl implements VoiceService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public String getVoice(int voiceId) {
        String url = "http://localhost:8000/customer/getvoice?id="+voiceId;
        return restTemplate.getForObject(url, String.class);
    }
}