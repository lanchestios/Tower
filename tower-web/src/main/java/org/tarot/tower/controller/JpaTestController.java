package org.tarot.tower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tarot.tower.common.entity.Shop;
import org.tarot.tower.service.inter.JpaTestService;

import java.util.List;

/**
 * @package: org.tarot.tower.controller
 * @author: 王子豪
 * @date: 2020/11/18 13:33
 * @description: JPA测试 - hibernate测试
 */
@RestController
@RequestMapping("/jpa")
public class JpaTestController {

    @Autowired
    private JpaTestService jpaTestService;

    // JPA 默认检索方法调用
    @RequestMapping("/defaultfunc")
    public List<Shop> jpaDefaultQueryTest(){
        return jpaTestService.jpaDefaultQueryTest();
    }

    // JPA 分页
    @RequestMapping("/page")
    public Page<Shop> jpaPaginationTest(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "PageSize", defaultValue = "10") int pageSize
    ) {
        return jpaTestService.jpaDefaultQueryTest(PageRequest.of(pageNo,pageSize));
    }

    // JPA 多表级联
    @RequestMapping("/cascade")
    public List<Shop> jpaCascadeTest() {
        return null;
    }

    // JPA 模糊查询 -- 注解
    @RequestMapping("/fuzzyQuery")
    public Page<Shop> jpaFuzzyQueryTest(
            @RequestParam(value = "searchText", defaultValue = "") String searchText,
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "PageSize", defaultValue = "10") int pageSize
    ){
        return jpaTestService.jpaFuzzyQueryTest(searchText, PageRequest.of(pageNo, pageSize));
    }
    
}
