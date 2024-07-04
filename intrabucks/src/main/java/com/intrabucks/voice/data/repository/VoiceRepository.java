package com.intrabucks.voice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Voice;

public interface VoiceRepository extends JpaRepository<Voice, Long> {

    Voice findByVoiceId(int voiceId);
}
