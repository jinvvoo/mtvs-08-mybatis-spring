package com.ohgiraffers.mybatisspring.configuration;

import com.ohgiraffers.mybatisspring.section01.factorybean.MenuMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfiguration {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.jdbc-url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean(destroyMethod = "close")      // 몰라 10:30
    public HikariDataSource dataSource() {

        /* 필기
        * DataSource : javax.sql 패키지에서 제공하는 인터페이스
        * 예전 데이터소스 이용할 때 BasicDataSource 이용했음
        * BasicDataSource : commons-dbcp 모듈에서 제공하는 dataSource 구현체
        * HikariDataSource : hikari-cp 모듈에서 제공하는 dataSource 구현체
        */

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        dataSource.setConnectionTimeout(30000);     //connection 생성하기 전에 대기하는 시간이 30000ms 30초
        dataSource.setIdleTimeout(600000);          //사용하지 않고 있을 떄 최대한 유지하고 있는 시간
        dataSource.setMaxLifetime(1800000);         // 하나의 커넥션이 최대 살아있는 시간

        dataSource.setMaximumPoolSize(50);          // 몰라

        return dataSource;
    }

    // sqlsessionfactory bean 제공하고 있다. 자동으로 추가됐으면 좋겠다
    // 몰라 10:28
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {

        org.apache.ibatis.session.Configuration configuration =
                new org.apache.ibatis.session.Configuration();
        configuration.addMapper(MenuMapper.class);

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setConfiguration(configuration);


        return factoryBean.getObject();
    }

    // getConnection 사전제공이
    // 몰라
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

}

//DB접속을 위한 mybatis 설정 끝.

// 이 환경설정은 그대로 두기

// 이런 설정은 우리가 잘 안씀
