package org.tarot.tower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//启用 Zuul代理 (ZuulProxy可视为ZuulServer增强版)
//当Zuul与Eureka、Ribbon等组件配合使用时，使用 @EnableZuulProxy
//ZuulProxy默认添加了@EnableCircuitBreaker注解
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
