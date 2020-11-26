package org.tarot.tower.configure.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @package: org.tarot.tower.configure.exception
 * @author: 王子豪
 * @date: 2020/11/20 18:41
 * @description:
 *  全局异常配置两种方式
 *  GlobalExceptionHandler全局异常配置(注解方式)
 *  GlobalExceptionResolver全局异常配置(实现HandlerExceptionResolver)
 */
/**
 * Java注解分类：
 * 1. @Controller 控制器(注入服务) 标注控制层组件
 * 2. @Service 服务(注入Dao) 标注业务层组件
 * 3. @Repository Dao(实现Dao访问) 标注数据访问组件
 * 4. @Component 泛指组件，不好归类的组件可使用该注解进行标注
 *    (把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>)
 *    用下述配置引入component扫描组件
 *    <context:component-scan base-package=”org.tarot”>
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        与GlobalExceptionHandler处理逻辑相同
//        在此不做赘述
//        if (ex instanceof IOException){}
        return null;
    }
}
