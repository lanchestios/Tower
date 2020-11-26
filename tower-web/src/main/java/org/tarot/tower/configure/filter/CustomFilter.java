package org.tarot.tower.configure.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @package: org.tarot.tower.configure.filter
 * @author: 王子豪
 * @date: 2020/11/20 23:18
 * @description: 自定义Filter
 * 可将 Filter 作为 Servlet 的一种“变种”，是典型的职责链模式，
 * 它主要用于对 HttpServletRequest 进行预处理，
 * 也可以对 HttpServletResponse 进行后处理。
 *
 * Filter 与 Servlet 的区别在于，它不能直接向用户生成响应。在 HttpServletRequest 到达Servlet之前，
 * Filter 拦截客户端的请求并进行头和内容的检查修改
 * Filter 拦截服务端的响应并进行头和内容的检查修改
 *
 * 主要应用场景：
 * 口禁用浏览器的缓存（缓存处理）
 * 口解决中文乱码的问题
 * 口检查用户是否登录来管理用户权限
 * 口用户授权的 Filter:Filter负责检查用户请求，根据请求过滤用户非法请求
 * 口日志 Filter：详细记录某些特殊的用户请求
 * 口负责解码的 Filter：包括对非标准编码的请求解码
 * 口其他特殊场景等
 */
@WebFilter(urlPatterns = {"/CustomServlet"})
public class CustomFilter implements Filter {
    //初始化关于Filter接口的参数，只在启动时调用一次
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("------------- FILTER INIT -------------");
        System.out.println("------------- " + filterConfig.getFilterName() + " -------------");
        Enumeration<String> names = filterConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }
        System.out.println("------------- FILTER INIT END -------------");
    }

    //存放过滤器业务逻辑代码
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("------------- FILTER DO -------------");
        //
        // doFilter执行前对用户请求预处理
        //
        chain.doFilter(request, response); // 处理请求和响应的分界线
        //
        // doFilter执行后对用户响应后处理
        //
        System.out.println("------------- FILTER DO END -------------");

    }

    //当Servlet容器销毁前调用该方法
    @Override
    public void destroy() {
        System.out.println("------------- FILTER DESTROY -------------");
    }
}
