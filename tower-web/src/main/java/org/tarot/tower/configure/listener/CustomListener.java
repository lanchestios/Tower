package org.tarot.tower.configure.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @package: org.tarot.tower.configure.listener
 * @author: 王子豪
 * @date: 2020/11/20 23:44
 * @description: 自定义Listener
 * 对以下几个接口进行实现：
 * //Session相关
 * 1. javax.servlet.http.HttpSessionListener
 * 2. javax.servlet.http.HttpSessionIdListener
 * 3. javax.servlet.http.HttpSessionAttributeListener
 * //ServletContext相关
 * 4. javax.servlet.ServletContextListener
 * 5. javax.servlet.ServletContextAttributeListener
 * //ServletRequest相关
 * 6. javax.servlet.ServletRequestListener
 * 7. javax.servlet.ServletRequestAttributeListener
 *
 * Servlet的监听器 Listener是实现了 javax.servlet.ServletContextListener 接口的服务器端程序，
 * 随Web应用的启动而启动，只初始化一次，随Web应用的停止而销毁。
 * 其主要作用是：做一些初始化的内容添加工作，设置一些基本的内容，比如一些参数或者一些固定的对象等。
 */
@WebListener
public class CustomListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("------------- LISTENER INIT -------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("------------- LISTENER DESTROY -------------");
    }
}
