package com.example.sunminprac.session;

import org.springframework.stereotype.Component;

// 세션 관리는 크게 3가지 기능을 제공하면 됨.
// 1. 세션 생성 : sessionId생성. 세션 저장소에 sessionId와 보관할 값 저장. sessionId로 응답쿠키를 생성해서 클라이언트에 전달
// 2. 세션 조회 : 클라이언트가 요청한 sessionId 쿠키의 값으로, 세션 저장소에 보관한 값 조회
// 3. 세션 만료 : 클라이언트가 요청한 sessionId 쿠키의 값으로, 세션 저장소에 보관한 sessionId 값 제거


@Component
public class sessionManager {

    private void createSession(){

    }

    private void getSession(){

    }

    private void expire(){

    }
}
