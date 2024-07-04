package com.intrabucks.voice.service;

import com.intrabucks.customer.data.repository.CustomerRepository;
import com.intrabucks.employee.data.repository.EmployeeRepository;
import com.intrabucks.entity.Employee;
import com.intrabucks.entity.Voice;
import com.intrabucks.store.data.repository.StoreRepository;
import com.intrabucks.voice.data.repository.VoiceRepository;
import com.intrabucks.voice.dto.AnswerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Date;
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
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StoreRepository storeRepository;

    /** Voice 고객의 소리 */
    /*공홈에서 정보를 가져와서 저장*/
    @Override
    public String getVoice() {
        String url = "http://localhost:8000/api/customer/getvoice";
        ResponseEntity<List<Voice>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Voice>>() {}
        );
        List<Voice> voices = response.getBody();
        voiceRepository.saveAll(voices);

        return "Success";
    }

    /*리액트로 보내는 고객의 소리*/
    @Override
    public List<Voice> selectAllVoice() {
        return voiceRepository.findAll();
    }


    /* 고객의 소리 답변 Answer */
   /**리액트에서 입력한 답변 저장*/

    @Override
    public String saveAnswer(AnswerRequestDto answerRequestDto) {

        Date today = new Date();
        // Voice 객체 생성 및 값 설정
        Voice voice = voiceRepository.findByVoiceId(answerRequestDto.getVoiceId());
        voice.setAnswerContent(answerRequestDto.getAnswerContent());
        voice.setAnswerDate(today);
        voice.setEmployee(employeeRepository.findByEmpId(answerRequestDto.getEmployee()));
        voice.setVoiceState("처리완료");


        // Voice 객체 저장
        voiceRepository.save(voice);

        return "success";
    }

// ------------------------------

    @Override
    public List<Voice> getAnswer(long custId) {
        return voiceRepository.findByCustomerCustId(custId);
    }


    /*공홈으로 답변 전송*/
//    @Override
//    public String sendAnswer(long voiceId) {
//        return "";
//    }
}