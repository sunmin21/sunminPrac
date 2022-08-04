package com.example.sunminprac.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;

//참고문서
// https://fvor001.tistory.com/30
// https://jung-max.github.io/2020/06/24/Web-3_SpringBoot-MariaDb%EC%97%B0%EA%B2%B0/
// mybatis 문서 https://mybatis.org/spring/ko/mappers.htsml

@Configuration	//해당 클래스가 스프링 빈 설정 클래스임을 나타냄

//매퍼주입
//1.mapper 클래스에 @mapper 달기
//2.db설정 클래스 파일에 @MapperScan 달기

//mapper scan -> 매퍼를 하나씩 등록하는게 아닌, 패키지 경로를 지정해서 이하 위치에 있는 인터페이스들은 전부 맵퍼로 사용할 수 있다.
//MapperScan(value="매퍼 인터페이스 경로")
//@MapperScan(value = {"com.example.sunminprac.pracDb1.*"}, sqlSessionFactoryRef="sqlSessionFactory")
@MapperScan(basePackages = {"com.example.sunminprac.**.mapper"},sqlSessionFactoryRef="sqlSessionFactory", annotationClass=com.example.sunminprac.annotation.newAnnotation.class)
public class dbConfig {
    // application.yml에 설정해놓은 db값을 가져와서 세팅

    //@Value : application.yml / application.properties에 정의된 값을 간단하게 주입
    //단점 -> boolean이 String으로도 사용되기 때문에, 타입안정성을 가지기 힘들다
    //@ConfigurationProperties -> 타입안정성을 가짐. 사용할 땐 꼭 @Getter/@Setter 사용
    @Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

//	@Value("${mybatis.type-aliases-package}")
//	private String typeAliasesPackage;
//
//	@Value("${mybatis.mapper-locations}")
//	private String mapperLocation;

	//등록된 bean을 의존성 주입받아 사용
	@Autowired
    ApplicationContext applicationContext;

	//Bean???
	//@Configuration 설정된 클래스의 메소드에서 사용 가능
	//bean 등록 방법
	//1.클래스 선언부 위에 @Component 어노테이션 사용. @Component를 통해 Configuration에 설정된 클래스가 아니라도, 빈 객체 생성 가능(ex. @Component, @Controller, @Service...)
	//2.자바코드로 직접 빈 등록. @Configuration 어노테이션을 클래스 선언부 위 추가 후, 메소드 위에 @Bean 어노테이션 설정.
	//@Bean(name="name") 사용 가능
	@Bean
	public DataSource dataSource() {
		System.out.println("dataSource!!!!!!!!!!!!!");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		return dataSource;
	}

	//sqlSessionFactory??
	//데이터베이스와의 연결과 sql의 실행에 대한 모든 것을 가진 객체
	//이 객체가 DataSource를 참조해서 MyBatis-Mysql 서버를 연동시켜줌
	//sqlSessionFactoryBean -> sqlSessionFactory를 생성
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
		System.out.println("sqlSessionFactory!!!!!!!!!!!!!");
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        factoryBean.setDataSource(dataSource);
//        factoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis/mybatis-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/db1/query.xml"));

        return factoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		System.out.println("sqlSession!!!!!!!!!!!!!");
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}