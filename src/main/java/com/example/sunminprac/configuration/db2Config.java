package com.example.sunminprac.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
//@MapperScan(value = {"com.example.sunminprac.pracDb2.*"}, sqlSessionFactoryRef="sqlSessionFactory2")
@MapperScan(basePackages = {"com.example.sunminprac.*"},sqlSessionFactoryRef="sqlSessionFactory2", annotationClass=com.example.sunminprac.annotation.newAnnotation2.class)
public class db2Config {
     @Value("${spring.datasource1.driver-class-name}")
	private String driverClassName1;

	@Value("${spring.datasource1.url}")
	private String url1;

	@Value("${spring.datasource1.username}")
	private String username1;

	@Value("${spring.datasource1.password}")
	private String password1;

	@Autowired
    ApplicationContext applicationContext;

    @Bean
	public DataSource dataSource1() {
		System.out.println("dataSource1!!!!!!!!!!!!!");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName1);
		dataSource.setUrl(url1);
		dataSource.setUsername(username1);
		dataSource.setPassword(password1);

		return dataSource;
	}
    @Bean(name="sqlSessionFactory2")
    public SqlSessionFactoryBean sqlSessionFactory2(DataSource dataSource1) throws IOException {
		System.out.println("sqlSessionFactory2222!!!!!!!!!!!!!");
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        factoryBean.setDataSource(dataSource1);
//        factoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis/mybatis-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/db2/query.xml"));
        return factoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSession2(SqlSessionFactory sqlSessionFactory) {
		System.out.println("sqlSession2222!!!!!!!!!!!!!");
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
