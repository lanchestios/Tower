package org.tarot.tower.configure.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @package: org.tarot.tower.configure.server
 * @author: 王子豪
 * @date: 2020/11/20 19:15
 * @description: 定制 TomcatServletWebServer
 * Spring boot 支持嵌入式容器（例如：Apache Tomcat、 Eclipse Jetty、 RedHat Undertow），默认启动嵌入式 Tomcat容器。
 * 可以在application.yml配置文件中设置，也可以通过自定义 WebServerFactoryCustomizer 接口来实现代码上的定制
 * 所有的WebServerFactoryCustomizer由WebServerFactoryCustomizerBeanPostProcessor调用
 */
@Component
public class TarotWebServerFactoryCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Autowired
    private Environment environment;

    @Override
    public void customize(TomcatServletWebServerFactory server) {
        /**
         * 等同于 application.yml 配置
         *   server: # 对Web服务器的配置
         *     port: 8080 # 端口
         */
        server.setPort(8080);
        /**
         * 获取 application.yml 中配置的 root.context.path 作为请求拦截根节点
         *   root:
         *     context:
         *       path: /tower
         * 通过此设置，需要通过 ip:port/tower 访问网站
         */
//        server.setContextPath(environment.getProperty("root.context.path"));
        server.setUriEncoding(StandardCharsets.UTF_8);
    }
}
