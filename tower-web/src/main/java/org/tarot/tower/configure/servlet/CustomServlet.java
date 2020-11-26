package org.tarot.tower.configure.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @package: org.tarot.tower.configure.servlet
 * @author: 王子豪
 * @date: 2020/11/20 20:30
 * @description: 自定义的Servlet
 * 该注解的作用等价为 web.xml => <servlet> 配置
 * <servlet>
 * <!-- 类名 -->
 * <servlet-name>CustomServlet</servlet-name>
 * <!-- 所在的包 -->
 * <servlet-class>org.tarot.tower.configure.servlet.CustomServlet</servlet-class>
 * <servlet-mapping>
 * <servlet-name>CustomServlet</servlet-name>
 * <!-- 访问的URL路径地址 -->
 * <url-pattern>/CustomServlet</url-pattern>
 * </servlet-mapping>
 * </servlet>
 */
@WebServlet(urlPatterns = {"/CustomServlet"})
//写完Servlet之后，要在SpringBoot入口类添加@ServletComponentScan注解，
//通知SpringBoot去扫描使用下面注解注册的Servlet、Filter、Listener
public class CustomServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /**
         * 自定义Servlet时需要删除这一行
         * super.doGet(req, resp);
         *  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         *     throws ServletException, IOException
         *  {
         *     String msg = lStrings.getString("http.method_get_not_supported");
         *     sendMethodNotAllowed(req, resp, msg);
         *  }
         *  会直接抛出一个方法调用不允许
         *
         */
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("------------------------------------------------------");
        System.out.println(String.format("CustomServlet GET / POST URL %s", req.getRequestURL()));
        System.out.println("Cookies: " + Arrays.toString(req.getCookies()));
        System.out.println("ContentType: " + req.getContentType());
        System.out.println("------------------------------------------------------");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("A CUSTOM SERVLET AND ITS ATTRIBUTES PRINT IN THE CONSOLE");
    }
}
