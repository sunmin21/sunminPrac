package com.example.sunminprac.pracDb2.mapper;
import com.example.sunminprac.annotation.newAnnotation2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

//DTO(Data Transfer Object) 계층 간 데이터 교환을 위해 사용하는 객체 =? Model

//DAO 데이터에 접근하는 객체. DB에서 데이터를 얻어 Service, Controller로 데이터 전송 시 사용 =? Mapper

//Configuration에서 mapperscan으로 경로지정을 해주면, mapper에서는 @Mapper 어노테이션을 쓰지 않아도 된다
@Mapper
@newAnnotation2
//@Qualifier("sqlSessionFactory2")
public interface sunmin2Mapper {
    public List<Object> select();
}