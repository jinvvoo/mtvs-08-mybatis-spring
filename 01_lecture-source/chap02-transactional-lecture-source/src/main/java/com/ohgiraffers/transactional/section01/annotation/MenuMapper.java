package com.ohgiraffers.transactional.section01.annotation;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper     // 아무 기능도 하지 않는 빈 껍대기이다. 구분목적으로 사용하는 어노테이션
public interface MenuMapper {

    List<Menu> findMenusByMenuCode(Map<String, List<Integer>> menuCodes);
}
