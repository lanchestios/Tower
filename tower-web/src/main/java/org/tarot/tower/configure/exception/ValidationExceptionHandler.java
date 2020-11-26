package org.tarot.tower.configure.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @package: org.tarot.tower.configure.exception
 * @author: 王子豪
 * @date: 2020/11/22 13:55
 * @description: 数据校验异常拦截
 */
@RestControllerAdvice
public class ValidationExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ValidationExceptionHandler.class);

    /**
     * 通过Controller层直接获取数据校验错误后不进入该方法
     */
    @ExceptionHandler(BindException.class)
    public void resolveBindException(HttpServletRequest request,
                       HttpServletResponse response,
                       BindingResult br,
                       Exception e) {
        StringBuffer sb = new StringBuffer("数据校验参数错误：");
        for (FieldError field : br.getFieldErrors()) {
            sb.append(field.getField() + " "
                    + field.getRejectedValue() + " "
                    + field.getDefaultMessage() + "; "
            );
        }
        logger.error(sb.toString());
    }
}
