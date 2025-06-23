package org.scoula.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 채팅 메시지 데이터 클래스
 * 
 * 역할:
 * 1. 클라이언트와 서버 간 채팅 메시지 데이터 구조 정의
 * 2. JSON ↔ Java 객체 자동 변환을 위한 모델
 * 3. STOMP 메시지의 body 부분에 해당하는 데이터
 * 
 * 💡 Jackson 라이브러리가 자동으로 JSON 변환 처리:
 * - 클라이언트 → 서버: JSON → ChatMessage 객체 (역직렬화)
 * - 서버 → 클라이언트: ChatMessage 객체 → JSON (직렬화)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    
    /**
     * 메시지 발신자 이름
     * - 클라이언트에서 입력한 사용자 이름
     * - 메시지 출력 시 "홍길동: 안녕하세요" 형태로 표시
     */
    private String name;
    
    /**
     * 메시지 내용
     * - 실제 채팅 텍스트
     * - 서버에서 필터링, 검증 등의 처리 대상
     */
    private String content;
    

}

/*
 * 📋 JSON 변환 예시:
 * 
 * 클라이언트에서 서버로 전송하는 JSON:
 * {
 *   "name": "홍길동",
 *   "content": "안녕하세요!"
 * }
 * 
 * ↓ 자동 역직렬화
 * 
 * ChatMessage 객체:
 * ChatMessage(name="홍길동", content="안녕하세요!")
 * 
 * ↓ 서버 처리 후 자동 직렬화
 * 
 * 클라이언트로 전송되는 JSON:
 * {
 *   "name": "홍길동", 
 *   "content": "안녕하세요!"
 * }
 */