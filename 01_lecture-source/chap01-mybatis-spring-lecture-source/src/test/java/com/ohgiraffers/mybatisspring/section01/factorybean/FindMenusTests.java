package com.ohgiraffers.mybatisspring.section01.factorybean;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FindMenusTests {

    @Autowired
    private MenuService menuService;

    @Test
    void testFindAllMenus(){            // 딱히 외부에서 쓸 일 없으니 디폴트 이상으로만

        Assertions.assertDoesNotThrow(
                () -> {
                    List<MenuDTO> menus = menuService.findAllMenus();
                    menus.forEach(System.out::println);
                }
        );

    }
}
