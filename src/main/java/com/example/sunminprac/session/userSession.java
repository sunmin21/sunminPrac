package com.example.sunminprac.session;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

/*
* 참고링크
* https://atoz-develop.tistory.com/entry/Spring-%EB%B9%88%EC%9D%98-Scope-%EC%8B%B1%EA%B8%80%ED%86%A4%EA%B3%BC-%ED%94%84%EB%A1%9C%ED%86%A0%ED%83%80%EC%9E%85
* */


@Setter
@Getter
@Component
//SCOPE_SESSION -> 객체가 한 세션에서 생명주기를 갖도록 bean scope를 session으로 설정
//bean scope를 session으로 설정할 경우에는 proxyMode를 TARGET_CLASS로 설정해줘야 한다. 왜??
//bean 정의할 때 session scope로 정의하면 브라우저가 서버에 최초의 요청을 보낼 때 bean 객체가 주입된다. 그 이후로는 다시 주입되지 않는다.

// scope : 스프링 빈이 존재할 수 있는 범위.
// 스코프를 지정해주지 않은 스프링 빈은 싱글톤 스코프임. 싱글톤 스코프로 지정된 빈은 어느 곳에서 주입되었던 간에 동일한 빈을 사용한다. 스프링 컨테이너 종료 시 소멸메서드도 자동 실행 됨
// 프로토타입 스코프로 지정된 빈은 주입될 때 마다 새로운 빈을 생성한다. 하지만 싱글톤 빈과는 다르게 빈 생성/의존관계 주입/초기화까지만 진행 하고, 소멸메소드 같은 것은 클라이언트에서 자체적으로 관리해야 한다.
// -> 즉 싱글톤은 스프링 컨테이너와 생명주기를 같이하지만, 프로토타입 빈은 생명주기를 달리한다.
// 싱글톤빈에서 프로토타입빈을 참조하는 경우 문제가 생긴다. (프로토타입 빈에서 싱글톤 빈을 참조하는 경우에는 문제없음)
// 싱글톤 빈의 인스턴스는 단 한번만 생성되고, 그때 프로토타입 빈의 주입도 이미 완료되기 때문에 싱글톤빈을 사용할때 프로토타입 빈이 업데이트 되지않음.
// 웹스코프로 지정하면 웹 환경에서만 동작한다. 종료메서드도 호출됨. request, session, application, websocket 종류가 있음.
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@ToString
public class userSession implements Serializable {    //Serializable -> 객체를 직렬화 하여 자바 외부 시스템에서도 사용할 수 있도록 Byte 형태로 변환. 외부 Redis와 같은 데이터베이스에 세션을 저장할거기 때문. 외부에 저장하지 않고 애플리케이션 서버 내에 메모리에서 해결할 계획이라면 직렬화 필요하지 않음.

	private static final long serialVersionUID = 1L;

	private String userId;
	private String userNm;
}
