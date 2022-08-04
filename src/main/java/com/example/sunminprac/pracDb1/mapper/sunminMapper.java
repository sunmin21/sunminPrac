package com.example.sunminprac.pracDb1.mapper;
import com.example.sunminprac.annotation.newAnnotation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

//DTO(Data Transfer Object) 계층 간 데이터 교환을 위해 사용하는 객체 =? Model

//DAO 데이터에 접근하는 객체. DB에서 데이터를 얻어 Service, Controller로 데이터 전송 시 사용 =? Mapper

@Mapper
@newAnnotation
//@Qualifier("dataSource")
public interface sunminMapper {
    public List<Object> select();
}