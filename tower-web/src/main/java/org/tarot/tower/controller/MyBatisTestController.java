package org.tarot.tower.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tarot.tower.common.entity.CommodityWithCate;
import org.tarot.tower.service.inter.MyBatisTestService;
import org.tarot.tower.common.entity.Commodity;

import java.util.List;

/**
 * @package: org.tarot.tower.controller
 * @author: 王子豪
 * @date: 2020/11/17 13:12
 * @description: 测试 MyBatis 相关功能
 */
@RestController
@RequestMapping("/mybatis")
public class MyBatisTestController {

    @Autowired
    private MyBatisTestService myBatisTestService;

    // 测试dao层访问数据库
    @RequestMapping("/dao")
    public Commodity daoTest() {
        return myBatisTestService.daoTest();
    }

    // 测试@Select无xml配置查询
    @RequestMapping("/annotation/select")
    public List<Commodity> annotationSelectOnMapperTest() {
        return myBatisTestService.annotationSelectOnMapperTest();
    }

    // 测试 pagehelper 分页
    @RequestMapping("/pagehelper")
    public PageInfo<Commodity> pagehelperTest(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        return myBatisTestService.pagehelperTest(pageNo, pageSize);
    }

    //测试 @Many 多表级联注解
    @RequestMapping("/annotation/many")
    public List<CommodityWithCate> annotationManyOnMapperTest() {
        return myBatisTestService.annotationManyOnMapperTest();
    }

}
