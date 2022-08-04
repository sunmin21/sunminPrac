package com.example.sunminprac.pracDb1.controller;

import com.example.sunminprac.pracDb1.service.sunminService;
import com.example.sunminprac.model.userModel;
import com.example.sunminprac.session.userSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

//과제 : springboot 설정 / mapper interface를 이용하여 다중db select하기 / mvc pattern 및 singletone pattern 이용

@RestController // -> 객체만을 반환하고 객체 데이터는 json/xml 형식으로 http 응답으로 전송.
//@Controller ->
public class sunminController {
    @Autowired
    sunminService sunminservice;

    @Resource
    private userSession userSession;

    @RequestMapping("/selectApiDb1")
    public Object selectApi() {
        System.out.println("123");
        return sunminservice.select();
    }

    @RequestMapping("/selectApiDb12")
    public Object selectApi2() {
        System.out.println("123");
        return sunminservice.select2();
    }

    @PostMapping(value = "/login")
//    public Object login(@RequestBody Object user){
    public Object login(@RequestBody @Valid userModel param){
        System.out.println(param.getUserId());

        userSession.setUserId(param.getUserId());
        userSession.setUserNm(param.getUserName());
//      userSession을 사용하여 API 호출 후 성공하면 서버에서 Cookie값으로 JSESSIONID를 발급받는다. 해당 API 호출할때마다 JSESSION값을 반환받는다.

        return null;
    }

//    @PostMapping(value="/logout")
//    public Object logout(){
//        userSession.
//    }


}
