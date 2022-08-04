package com.example.sunminprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;


//AOP를 활성화 하겠다는 어노테이션 추가.
@EnableAspectJAutoProxy
//스케쥴링
@EnableScheduling
@SpringBootApplication
public class SunminPracApplication {
// spring boot VS spring MVC
    public static void main(String[] args) {
        System.out.println("main!!!!!!!!!!!!");
        SpringApplication.run(SunminPracApplication.class, args);
    }

}
