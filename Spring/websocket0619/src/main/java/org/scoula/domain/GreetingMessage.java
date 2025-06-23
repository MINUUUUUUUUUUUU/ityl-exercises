package org.scoula.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 사용자 입장 알림 메시지 데이터 클래스
 * 
 * 역할:
 * 1. 새로운 사용자가 채팅에 입장할 때의 메시지 구조 정의
 * 2. 입장 알림과 채팅 메시지를 구분하여 처리
 * 3. 클라이언트에서 입장 이벤트를 별도로 표시할 수 있도록 지원
 * 
 * 💡 ChatMessage와 분리한 이유:
 * - 입장 메시지와 일반 채팅 메시지의 처리 로직이 다름
 * - 향후 입장 메시지에만 필요한 추가 정보 확장 가능
 * - 클라이언트에서 메시지 타입별로 다른 UI 표시 가능
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GreetingMessage {
    
    /**
     * 입장하는 사용자의 이름
     * - 연결 시 클라이언트에서 입력한 사용자 이름
     * - "OOO님이 입장했습니다" 형태의 알림 메시지 생성에 사용
     */
    private String name;
}

/*
 * 🔄 입장 메시지 처리 흐름:
 * 
 * 1. 사용자가 이름 입력 후 '연결' 버튼 클릭
 *    ↓
 * 2. WebSocket 연결 성공 후 입장 메시지 자동 전송
 *    stompClient.send("/app/hello", JSON.stringify({name: "홍길동"}))
 *    ↓
 * 3. ChatController.greeting() 메서드에서 처리
 *    ↓
 * 4. /topic/greetings 토픽으로 브로드캐스트
 *    ↓
 * 5. 모든 클라이언트에서 "홍길동님이 입장했습니다" 메시지 표시
 * 
 * 📋 JSON 예시:
 * 전송: {"name": "홍길동"}
 * 수신: {"name": "홍길동"} → "홍길동님이 입장했습니다" 로 변환 표시
 */