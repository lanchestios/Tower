package org.tarot.tower.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.tarot.tower.configure.exception.AppException;

/**
 * @package: org.tarot.tower.controller
 * @author: 王子豪
 * @date: 2020/11/18 15:27
 * @description: 配置静态页面请求
 */
@Controller
public class _RouterController {

    //将 请求为 /* 的 转发到 * 页面
    @GetMapping("/{page}")
    public String getPage(@PathVariable String page) {
        return page;
    }

    //测试对全局异常处理的配置，只针对AppException
    @GetMapping("/exception/global")
    public String globalExceptionHandlerTest() throws AppException {
        throw new AppException();
    }
}
