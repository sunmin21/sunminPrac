package com.example.sunminprac.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//참고문서
//https://shinsunyoung.tistory.com/83


// target : 어노테이션이 생성될 수 있는 위치
//@Target({ElementType.CONSTRUCTOR}) // 1

//retention : 언제까지 유효할지 지정
@Retention(RetentionPolicy.RUNTIME) // 2
public @interface newAnnotation {
}
