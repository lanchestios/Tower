package org.tarot.tower.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package: org.tarot.tower.controller
 * @author: 王子豪
 * @date: 2020/11/16 21:50
 * @description: 测试 get post request 内容
 */
@RestController
@RequestMapping("/request")
public class RequestTestController {

    // 测试 GET 请求
    @GetMapping("/get")
    public String testGetRequest() {
        return "This is a get request";
    }

    // 测试 POST 请求
    @PostMapping("/post")
    public String testPostRequest() {
        return "This is a post request";
    }
}
