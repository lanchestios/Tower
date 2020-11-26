package org.tarot.tower;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @package: org.tarot.tower.filter
 * @author: 王子豪
 * @date: 2020/11/24 11:12
 * @description: Zuul自定义过滤器
 * 使用 API Gateway可以将"1对N"问题转换成了"1对1”问题，同时在请求到达真正的服务之前，
 * 可以做一些预处理工作。API Gateway可以完成诸如鉴权、流量控制、系统监控、页面缓存等功能，
 */
@Component
public class ZuulSimpleFilter extends ZuulFilter {

    @Override
    public String filterType() {
        //指定过滤器类型
        return "pre";
    }

    @Override
    public int filterOrder() {
        //过滤器优先级，越大越靠后执行
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        //判断是否需要过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        System.out.println("ZUUL URL: " + request.getRequestURL());
        return null;
    }
}
