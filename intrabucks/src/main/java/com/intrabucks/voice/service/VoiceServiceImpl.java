package com.intrabucks.voice.service;

import com.intrabucks.customer.data.repository.CustomerRepository;
import com.intrabucks.employee.data.repository.EmployeeRepository;
import com.intrabucks.entity.Employee;
import com.intrabucks.entity.Voice;
import com.intrabucks.store.data.repository.StoreRepository;
import com.intrabucks.voice.data.repository.VoiceRepository;
import com.intrabucks.voice.dto.AnswerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    public String getVoice(int voiceId) {
        String url = "http://localhost:8000/api/customer/getvoice?id="+voiceId;
        Voice voice = restTemplate.getForObject(url, Voice.class);
        voiceRepository.save(voice);
        return "Success";
    }

    /*리액트로 보내는 고객의 소리*/
    @Override
    public List<Voice> selectAllVoice() {
        return voiceRepository.findAll();
    }


// ------------------------------

    /** 고객의 소리 답변 Answer */
   /*리액트에서 입력한 답변 저장*/

//    @Override
//    public String saveAnswer(AnswerRequestDto answer) {
//        //Voice 엔티티를 ID로 조회
//        Voice voice = voiceRepository.findById(Long.valueOf(answer.getVoiceId()))
//                .orElseThrow(()-> new IllegalArgumentException("Invalid Voice ID:" +answer.getVoiceId()));
//        // Employee 엔티티를 ID로 조회
//        Employee employee = employeeRepository.findById(answer.getEmployee())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid Employee ID: " + answer.getEmployee()));
//
//        // 답변 내용 및 처리 상태 업데이트
//        voice.setAnswerContent(answer.getAnswerContent());
//        voice.setVoiceState(answer.getVoiceState());
//        voice.setAnswerDate(answer.getAnswerDate());
//        voice.setEmployee(employee);
//
//        // Voice 엔티티 저장
//        voiceRepository.save(voice);
//
//        return "Answer saved successfully";
//    }
    @Override
    public String saveAnswer(AnswerRequestDto answerRequestDto) {
//        Date today = new Date();
//        Employee employee = new Employee();
//        Voice answer = new Voice();
//        answer.setVoiceId(voiceRepository.findByVoiceId(answerRequestDto.getVoiceId()));
//        answer.setAnswerContent(answerRequestDto.getAnswerContent());
//        answer.setAnswerDate(today);
//        answer.setEmployee(employeeRepository.findById(answerRequestDto.getEmployee()));
//        voiceRepository.save(answer);
//        return "succes";
        Date today = new Date();

        // Voice 객체 생성 및 값 설정
        Voice answer = new Voice();
        answer.setVoiceId(answerRequestDto.getVoiceId()); // answerRequestDto에서 직접 ID를 가져와야 함

        answer.setAnswerContent(answerRequestDto.getAnswerContent());
        answer.setAnswerDate(today);

        // Employee 객체 생성 및 값 설정
        Employee employee = employeeRepository.findById(answerRequestDto.getEmployee())
                .orElseThrow(() -> new RuntimeException("Employee not found")); // Optional을 사용하여 null 체크

        answer.setEmployee(employee);

        // Voice 객체 저장
        voiceRepository.save(answer);

        return "success";
    }

    @Override
    public Voice getAnswer(int voiceId) {
        return null;
    }


    /*공홈으로 답변 전송*/
//    @Override
//    public String sendAnswer(long voiceId) {
//        return "";
//    }
}