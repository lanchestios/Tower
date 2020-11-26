package org.tarot.tower;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 打成war包的项目拥有，用来初始化Servlet
 * 如果war包中没有配置SpringMvc的DispatcherServlet的web.xml文件或者初始化 Servlet的类，
 * Tomcat就无法识别这个war包。需要SpringBootServletInitializer告诉Tomcat这个war包的启动人口
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TowerApplication.class);
    }
}
