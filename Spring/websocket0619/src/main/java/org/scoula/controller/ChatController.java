package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.domain.ChatMessage;
import org.scoula.domain.GreetingMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * STOMP 메시지 처리 컨트롤러
 * 
 * 역할:
 * 1. 클라이언트에서 발행한 메시지를 수신하여 처리
 * 2. 비즈니스 로직 실행 (검증, 변환, DB 저장 등)
 * 3. 처리 결과를 구독자들에게 브로드캐스트
 * 
 * 💡 일반 @RestController와의 차이점:
 * - HTTP 요청/응답이 아닌 STOMP 메시지를 처리
 * - @MessageMapping으로 메시지 경로를 매핑
 * - @SendTo로 응답을 특정 토픽으로 브로드캐스트
 */
@Controller
@Log4j2
public class ChatController {

    /**
     * 사용자 입장 메시지 처리
     * 
     * 흐름:
     * 1. 클라이언트가 "/app/hello"로 GreetingMessage 발행
     * 2. 이 메서드가 메시지를 수신하여 처리
     * 3. 처리 결과를 "/topic/greetings" 토픽의 모든 구독자에게 전송
     * 
     * @param message 클라이언트에서 전송한 입장 메시지 (JSON → 자동 역직렬화)
     * @return 처리된 메시지 (자동 직렬화 → JSON → 브로드캐스트)
     */
    @MessageMapping("/hello")     // 경로: /app/hello (config에서 설정한 prefix + mapping)
    @SendTo("/topic/greetings")   // 응답을 받을 토픽 (모든 구독자에게 브로드캐스트)
    public GreetingMessage greeting(GreetingMessage message) throws Exception {
        
        log.info("새로운 사용자 입장: {}", message.getName());

        // 💡 여기서 추가 비즈니스 로직 처리 가능:
        // - 사용자 입장 기록을 DB에 저장
        // - 입장 메시지 커스터마이징
        // - 사용자 권한 검증
        // - 온라인 사용자 목록 업데이트
        
        // 🔄 Return된 객체는 자동으로:
        // 1. JSON으로 직렬화
        // 2. /topic/greetings 토픽으로 전송
        // 3. 해당 토픽을 구독한 모든 클라이언트가 수신
        return message;
    }

    /**
     * 채팅 메시지 처리
     * 
     * 흐름:
     * 1. 클라이언트가 "/app/chat"으로 ChatMessage 발행
     * 2. 이 메서드가 메시지를 수신하여 처리
     * 3. 처리 결과를 "/topic/chat" 토픽의 모든 구독자에게 전송
     * 
     * @param message 클라이언트에서 전송한 채팅 메시지
     * @return 처리된 채팅 메시지
     */
    @MessageMapping("/chat")  // 경로: /app/chat (config에서 설정한 prefix + mapping)
    @SendTo("/topic/chat")    // 응답을 받을 토픽  (모든 구독자에게 브로드캐스트)
    public ChatMessage chat(ChatMessage message) throws Exception {

        log.info("채팅 메시지 수신 - 발신자: {}, 내용: {}",
                message.getName(), message.getContent());

        // 추가 비즈니스 로직 처리 코드 작성 부분...

        log.info("[채팅 메시지] 모든 구독자에게 브로드캐스트!!");
        return message;
    }

}

/*
 * 🔄 메시지 처리 흐름 상세:
 * 
 * [클라이언트] 
 *     ↓ stompClient.send("/app/chat", JSON.stringify(message))
 * [Spring WebSocket]
 *     ↓ STOMP 프로토콜 파싱
 * [@MessageMapping("/chat")]
 *     ↓ ChatMessage 객체로 역직렬화
 * [비즈니스 로직 처리]
 *     ↓ 검증, 변환, DB 저장 등
 * [@SendTo("/topic/chat")]
 *     ↓ 반환값을 JSON으로 직렬화
 * [Message Broker]
 *     ↓ /topic/chat 구독자들에게 브로드캐스트
 * [모든 구독 클라이언트]
 *     ↓ 메시지 수신 및 화면 표시
 */