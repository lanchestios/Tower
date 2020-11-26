package org.tarot.tower.actuator;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
/**
 * 注意也可使用 @EnableEurekaClient
 * 但由于 spring cloud 是灵活的，注册中心支持 eureka、consul、zookeeper等
 * 若写了具体的注册中心注解，则当替换成其他注册中心时，又需要替换成对应的注解了。
 * 所以 直接使用 @EnableDiscoveryClient 启动发现。
 * 这样在替换注册中心时，只需要替换相关依赖即可。
 */
@EnableDiscoveryClient
@EnableAdminServer
public class ActuatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }
}
