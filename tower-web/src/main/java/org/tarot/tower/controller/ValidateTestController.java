package org.tarot.tower.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tarot.tower.common.entity.Shop;

import javax.validation.Valid;

/**
 * @package: org.tarot.tower.controller
 * @author: 王子豪
 * @date: 2020/11/22 13:04
 * @description: 数据校验
 * 用法：
 * 在 Controller 层方法加入 BindingResult 参数
 * 如：public String validateTest(@Validated Shop shop, BindingResult br)
 * 数据校验失败会将失败内容录入 BindingResult br, 不会将 BindException 异常抛出
 *
 * 在全局异常配置中加入 BindException, 配置方法如 ValidationExceptionHandler
 */
@RestController
@RequestMapping("/validate")
public class ValidateTestController {

    @RequestMapping("/object")
    public String validateTest(@Validated Shop shop, BindingResult br) {
        return "校验通过";
    }
}
