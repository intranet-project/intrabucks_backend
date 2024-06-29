package com.intrabucks.voice.controller;

import com.intrabucks.voice.dto.voiceResponseDto;
import com.intrabucks.voice.service.VoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class VoiceController {
    @Autowired
    private VoiceService voiceService;

    @GetMapping("/voice")
    public String voice(@RequestParam int voiceId) {
        return voiceService.getVoice(voiceId);
    }
}
