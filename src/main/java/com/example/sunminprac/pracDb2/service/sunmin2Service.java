package com.example.sunminprac.pracDb2.service;

import com.example.sunminprac.pracDb2.mapper.sunmin2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sunmin2Service {

    @Autowired
    sunmin2Mapper sunminmapper;

    public Object select(){
        System.out.println("sunmin service");
        System.out.println(sunminmapper.select());
        return sunminmapper.select();
    }
}
