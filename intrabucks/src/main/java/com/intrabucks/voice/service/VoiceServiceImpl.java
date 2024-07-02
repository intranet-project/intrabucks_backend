package com.intrabucks.voice.service;

import com.intrabucks.entity.Voice;
import com.intrabucks.voice.data.repository.VoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 고객의 소리(intranet) 서비스
 * @author 최유빈
 * @since 2024-06-29
 * */
@Service
public class VoiceServiceImpl implements VoiceService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private VoiceRepository voiceRepository;

/** Voice 고객의 소리 */
    /*공홈에서 정보를 가져와서 저장*/
    @Override
    public String getVoice(int voiceId) {
        String url = "http://localhost:8000/customer/getvoice?id="+voiceId;
        Voice voice = restTemplate.getForObject(url, Voice.class);
        voiceRepository.save(voice);
        return "Success";
    }

   /* @Override
    public String saveVoice(VoiceResponseDto voiceResponseDto) {
        return "";
    }*/
    /*공홈에서 가져온 고객의 소리 정보 저장*/


    /*리액트로 보내는 고객의 소리*/
    @Override
    public List<Voice> selectAllVoice() {
        return voiceRepository.findAll();
    }


    /** 고객의 소리 답변 Answer */
//    /*리액트에서 입력한 답변 조회*/
//    @Override
//    public VoiceRequestDto getAnswer(long voiceId) {
//        return null;
//    }
//    /*리액트에서 입력한 답변 저장*/
//    @Override
//    public String saveAnswer(AnswerRequestDto AnswerRequestDto) {
//        return "";
//    }

//    @Override
//    public String sendAnswer(AnswerResponseDto AnswerResponseDto) {
//        return "";
//    }

    /*공홈으로 답변 전송*/
//    @Override
//    public String sendAnswer(long voiceId) {
//        return "";
//    }
}