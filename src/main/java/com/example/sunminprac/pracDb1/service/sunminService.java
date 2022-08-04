package com.example.sunminprac.pracDb1.service;

import com.example.sunminprac.pracDb1.mapper.sunminMapper;
import com.example.sunminprac.pracDb2.mapper.sunmin2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sunminService {

    //Autowired로 의존성 주입하는건 그렇게 좋지 않은 방법이라고 함.
    //코드가 간결하지만, 외부에서 변경하기 힘들고 프레임워크에 의존적이고 객체지향적으로 좋지 않다고 함.
    //바람직한 의존성 주입은, 생성자 주입 방법.
    @Autowired
    sunminMapper sunminMapper;

    @Autowired
    sunmin2Mapper sunmin2Mapper;

    public Object select(){
        System.out.println("sunmin service");
        System.out.println(sunminMapper.select());
        return sunminMapper.select();
    }

    public Object select2(){

        return sunmin2Mapper.select();
    }
}
