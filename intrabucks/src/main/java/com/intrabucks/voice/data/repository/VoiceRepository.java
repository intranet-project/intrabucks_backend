package com.intrabucks.voice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.Voice;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoiceRepository extends JpaRepository<Voice, Long> {

    Voice findByVoiceId(int voiceId);


    List<Voice> findByCustomerCustId(long custId);
}
