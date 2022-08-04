package com.example.sunminprac.pracDb2.controller;

import com.example.sunminprac.pracDb2.service.sunmin2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//과제 : springboot 설정 / mapper interface를 이용하여 다중db select하기 / mvc pattern 및 singletone pattern 이용

@RestController // -> 객체만을 반환하고 객체 데이터는 json/xml 형식으로 http 응답으로 전송.
//@Controller ->
public class sunmin2Controller {
    @Autowired
    sunmin2Service sunminservice;

    @RequestMapping("/selectApiDb2")
    public Object selectApi() {
        System.out.println("123");
        return sunminservice.select();
    }

}
