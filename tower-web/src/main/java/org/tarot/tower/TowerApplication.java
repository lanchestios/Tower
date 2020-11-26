package org.tarot.tower;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
/**
 * 对于扫描 MyBatis Dao
 * 可以在主入口类配置 @MapperScan
 * 也可以通过在 Dao 上单独添加 @Mapper 注解
 */
@MapperScan("org.tarot.tower.common.dao")
@EnableWebMvc
//通知SpringBoot去扫描使用下面注解注册的Servlet、Filter、Listener
@ServletComponentScan
//启用 Spring Schedule 定时调度功能
//@EnableScheduling
//启用 异步模式(使用 @Async)
@EnableAsync
//启用 缓存功能
@EnableCaching
public class TowerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TowerApplication.class, args);
    }
}
