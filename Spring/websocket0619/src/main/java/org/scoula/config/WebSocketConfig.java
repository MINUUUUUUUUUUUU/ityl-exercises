package org.scoula.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket과 STOMP 프로토콜 설정 클래스
 * 
 * 역할:
 * 1. WebSocket 연결 엔드포인트 정의
 * 2. 메시지 브로커 설정 (메시지 라우팅 규칙)
 * 3. STOMP 프로토콜 활성화
 */
@Configuration
@EnableWebSocketMessageBroker  // WebSocket 메시지 브로커 기능 활성화 (STOMP 프로토콜 사용)
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 메시지 브로커 설정
     * - 클라이언트와 서버 간 메시지 라우팅 규칙을 정의
     * - STOMP 메시지의 목적지(destination) 경로 규칙 설정
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        
        // 1. 메모리 기반 Simple Message Broker 활성화
        // - "/topic"으로 시작하는 destination을 가진 메시지들을 브로커가 처리
        // - 구독자들에게 메시지를 브로드캐스트하는 역할
        // - 예: "/topic/chat", "/topic/greetings" 등
        config.enableSimpleBroker("/topic");
        
        // 💡 참고: 운영환경에서는 RabbitMQ, ActiveMQ 같은 외부 브로커 사용 권장
        // config.enableStompBrokerRelay("/topic").setRelayHost("localhost").setRelayPort(61613);
        
        // 2. 애플리케이션 destination prefix 설정
        // - 클라이언트가 서버로 메시지를 보낼 때 사용하는 경로의 prefix
        // - "/app"으로 시작하는 메시지는 @MessageMapping이 있는 컨트롤러 메서드로 라우팅
        // - 예: "/app/chat", "/app/hello" 등
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * STOMP 엔드포인트 등록
     * - 클라이언트가 WebSocket 연결을 시작할 때 사용하는 URL 정의
     * - HTTP 핸드셰이크 후 WebSocket 프로토콜로 업그레이드
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        
        // WebSocket 연결 엔드포인트 등록
        registry.addEndpoint("/chat-app")       // 연결 URL: ws://localhost:8080/chat-app
                .setAllowedOrigins("*");               // CORS 정책: 모든 오리진 허용
        
        // 🚨 보안 주의: 운영환경에서는 구체적인 도메인 지정 권장
        // .setAllowedOrigins("https://yourdomain.com", "https://anotherdomain.com");
        
        // 💡 SockJS 지원 (WebSocket을 지원하지 않는 브라우저 대응)
        // .withSockJS(); // 필요시 추가
    }
}

/*
 * 🔄 STOMP 메시지 흐름 요약:
 * 
 * 1. 클라이언트 연결: ws://localhost:8080/chat-app
 * 2. 토픽 구독: client.subscribe("/topic/chat")
 * 3. 메시지 발행: client.send("/app/chat", message)
 * 4. 서버 처리: @MessageMapping("/chat") 메서드 실행
 * 5. 브로드캐스트: @SendTo("/topic/chat")로 모든 구독자에게 전송
 */