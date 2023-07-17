package com.ohgiraffers.transactional.section01.configuration;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ohgiraffers.transactional", annotationClass = Mapper.class)        // 매퍼 편하게 등록할 수 있는 방법
public class MybatisConfiguration {

}
