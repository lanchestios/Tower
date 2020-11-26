package org.tarot.tower.configure.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @package: org.tarot.tower.configure.exception
 * @author: 王子豪
 * @date: 2020/11/20 16:14
 * @description:
 * 全局异常配置两种方式
 *  GlobalExceptionHandler全局异常配置(注解方式)
 *  GlobalExceptionResolver全局异常配置(实现HandlerExceptionResolver)
 */
//使用＠ControllerAdvice将控制层的异常和数据校验的异常进行统一处理
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //通过@ExceptionHandler对指定Exception进行捕获
    @ExceptionHandler(value = AppException.class)
    ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        logger.error("GlobalExceptionHandler ==> {}", e.getMessage());
        e.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("stackTrace", e.getStackTrace());
        mav.addObject("errorMessage", e.getMessage());
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("forward:/error/500");
        return mav;
    }
}
