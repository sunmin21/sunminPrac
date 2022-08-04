package com.example.sunminprac.exception;

import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


// ControllerAdvice : 모든 @Controller에 대한 전역적으로 발생할 수 있는 예외를 잡하서 처리할 수 있음.

// RestControllerAdvice : @ControllerAdvice + @ResponseBody 합쳐놓은 어노테이션
// @ControllerAdvice와 동일한 역할을 수행하고, 추가적으로 @ResponseBody를 통해 객체를 리턴할 수도 있다.
// Json, xml 형식으로 return 할 경우 사용.
//@RestControllerAdvice(basePackages = "com.example.sunminprac") -> 적용할 패키지를 지정할 수 있다.
@RestControllerAdvice
public class globalException
{

    //@ExceptionHandler를 메서드에 선언하고 특정 예외 클래스를 지정해주면, 예외가 발생했을 때 해당 로직으로 처리할 수 있음.
    //MethodArgumentNotValidException : Controller @Valid 유효성체크에 통과하지 못하면 발생한다.
    // @ExceptionHandler(value={MethodArgumentNotValidException.class, JsonParseException.class})

    // ResponseStatus : Controller나 Exception에 사용하여 status 정보를 설정해서 리턴
    @ResponseStatus(HttpStatus.OK)
//    @ExceptionHandler(value={Exception.class})
     @ExceptionHandler(value={MethodArgumentNotValidException.class, JsonParseException.class})
    public void excep(){
        System.out.println("엉 예외");
    }
}
