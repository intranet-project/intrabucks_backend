package com.intrabucks.voice.controller;

import com.intrabucks.entity.Voice;
import com.intrabucks.voice.dto.AnswerRequestDto;
import com.intrabucks.voice.dto.AnswerResponseDto;
import com.intrabucks.voice.service.VoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * VoiceController
 * @author 최유빈
 * @version 1.2
 * 2024-07-04
 **/
@RestController
@RequestMapping("/api/v1/intrabucks/customer")
public class VoiceController {

    @Autowired
    private VoiceService voiceService;

    /**
     * 고객의 소리 (공홈 -> 인트라넷)
     */
    /* 공홈에서 받은 voice를 가져오고 service에서 저장 */
    @GetMapping("/voice")
    public List<Voice> voice() {
        voiceService.getVoice();
        return voiceService.selectAllVoice();

    }

    // 인트라넷 리액트에서 고객의 소리 조회
    @GetMapping("/voiceList")
    public List<Voice> voiceList() {
        return voiceService.selectAllVoice();
    }

//--------------------

    /**
     * 고객의 소리 답변(인트라넷 -> 공홈)
     */

    /* 리액트에서 받은 답변 저장 */

//---------------------
    /* 리액트에서 받은 답변 저장 */
    @PostMapping("/answer")
    public String saveAnswer(@RequestBody AnswerRequestDto answer) {
        //logger.info("Received voice registration request: {}", answer);

        return voiceService.saveAnswer(answer);
    }
//
    /* 공홈에서 요청이 들어왔을때*/
//    @GetMapping("/getanswer")
//    public List<AnswerResponseDto> getAnswer() {
//        public Voice getAnswer(@RequestParam("id") int voiceId) {
//            return voiceService.getAnswer(voiceId);
//        }
//}
    @GetMapping("/getanswer")
    public Voice getAnswer(@RequestParam("id") long voiceId) {
    return voiceService.getAnswer((int) voiceId);
}
    /* 공홈으로 답변 전송 */
//    @GetMapping("/voiceAnswer/{voiceId}")
////    public ResponseEntity<String> saveAnswer(@RequestBody voiceResponseDto voiceResponseDto) {
////        String result = voiceService.saveAnswer(voiceResponseDto);
////        return ResponseEntity.ok(result);
//    public AnswerResponseDto getAnswer(@RequestParam("id") long voiceId) {
//        return voiceService.getAnswer(voiceId);
//    }
}
