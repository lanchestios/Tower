package org.tarot.tower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tarot.tower.common.entity.Shop;
import org.tarot.tower.service.inter.SpringBootTestService;

/**
 * @package: org.tarot.tower.controller
 * @author: 王子豪
 * @date: 2020/11/16 21:53
 * @description: 测试 SpringBoot 功能
 */
@RestController
@RequestMapping("/service")
public class SpringBootTestController {

    // 测试自动注入
    @Autowired
    private SpringBootTestService autowireTest;
    @GetMapping("/autowire")
    public String testAutowire() {
        return autowireTest.getServiceInfo();
    }

    // @ResponseBody 作用是将 Java 对象转化为 Json 格式的字符串
    // 如不加 @ResponseBody, 前端 js 获取到的是一个 Object 对象
    // 加上 @ResponseBody, 前段 js 获取到的是一个 json 字符串
    @RequestMapping(value = "/response-body")
    @ResponseBody
    public Shop responseBodyTest() {
        Shop shop = new Shop();
        shop.setShopName("Tarot Shop");
        shop.setShopAddress("Tarot Address");
        return shop;
    }

    // @RequestBody 接收 Request Body 中的 JSON 数据录入 POJO
    // application/x-www-form-urlencoded 可选 @RequestParam, @ModelAttribute, @RequestBody 均可处理
    // multipart/form-data, @RequestBody不能处理
    // 其他格式 必须(其他格式包括  application/json, application/xml 等)
    @RequestMapping(value = "/request-body")
    public void requestBodyTest(@RequestBody Shop shop) {
        System.out.println(shop);
    }
}
