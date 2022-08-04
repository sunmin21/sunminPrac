package com.example.sunminprac.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//참고문서
//https://congsong.tistory.com/25

//bean으로 등록하기 위한 어노테이션.
//@bean : 개발자가 제어할 수 없는 외부 라이브러리를 빈으로 등록할 때 사용
//@Component : 개발자가 직접정의한 클래스를 빈으로 등록할 때 사용
@Component
//@Aspect : 공통적으로 적용될 기능을 의미. 부가 기능 모듈.
//AOP 클래스로 설정하기 위해 해당 어노테이션 사용
@Aspect
public class aopComponent {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //within : 메소드가 아닌 특정 타입에 속한 메소드를 포인트컷으로 설정할 때 사용
    //@Pointcut("@within(com.exam.sunmin.annotation.BusanController)")

    // 부가기능이 적용될 대상(method)을 선정하는 방가
    @Pointcut
    public void pointCut(){

    }

    //Advice의 5가지 종류 중 한가지.
    //Around는 메서드의 호출 자체를 제어가능하기 때문에, 가장 강력한 기능
    //target 메서드 호출 이전, 이후 모두 적용가능
    //모든 패키지 내의 aop packages에 존재하는 클래스

    //@Around("bean(car)") -> carㄹㅏ는 bean id를 가지고 있는 bean에게 적용
    //around는 클라이언트 호출을 가로챈댜. around 메소드 안에서는 비즈니스 메소드 호출을 해주지 않으면, 비즈니스 메소드는 실행되지 않는다.
    //그러면 비즈니스 메소드에 대한 정보를 가지고 있어야 하는데, 그 정보를 ProceedingJoinPoint 객체가 그 정보를 가지고 있다.
   @Around("execution(* com.example.sunminprac.pracDb1.controller..*(..))")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable{
        //ProceedingJoinPoint : 호출되는 대상 객체에 대한 정보, 실행되는 메서드에 대한 정보, 메서드를 호출할 때 전달된 인자에 대한 정보 필요할 때 사용
       //pjp.getSignature() : 호출되는 메서드에 대한 정보를 구한다.
       //pjp.getSignature().getName() : 메서드의 이름을 구한다.
       //pjp.getSignature().toLongString() : 메서드를 완전하게 표현한 문장을 구한다.(메서드의 리턴타입, 파라미터 타입 모두 표시).
       //pjp.getSignature().getName() : 메서드를 축약해서 표현한 문장을 구한다.
       //pjp.getTarget() : 대상 객체를 구한다.
       //pjp.getArgs() : 파라미터의 목록을 구한다.

       System.out.println("잠와아앙");

       HttpServletRequest servletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
       HttpServletResponse servletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

       servletRequest.getHeader("cookie");
       servletRequest.getCookies();

       servletResponse.setContentType("text/plain");

       String methodname = pjp.getSignature().getName();
       try {
           logger.info(methodname+" start");
           //proceed()를 기준으로 비즈니스 메소드 수행 전/후가 나뉘어짐. proceed를 사용해야 호출메소드가 수행됨.
           //proceed()가 반환하는 값은 object인데, 이 값은 메소드가 실행한 후의 결과값이 담겨있다.
           Object result = null;
           result = pjp.proceed();
           if(result!=null){
                logger.info(methodname+" result : "+result);
           }
       return result;
       }finally {
           logger.info(methodname+" finish");
       }

    }

    //어노테이션을 직접 만들어서 Aspect 적용할수도 있음
    //logAnnotation 어노테이션을 만들어서, 시간측정을 하고 싶은 클래스 상단에 @logAnnotaion을 붙이면 적용.
    //@Around("@annotation(logAnnotation)")
    //public Object logging()....
}
