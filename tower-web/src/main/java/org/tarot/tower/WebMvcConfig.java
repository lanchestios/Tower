package org.tarot.tower;

import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @package: org.tarot.tower
 * @author: 王子豪
 * @date: 2020/11/18 15:32
 * @description: 通过 Java Config 方法启用 SpringMVC 配置
 * 需要在入口函数加@EnableWebMvc注解开启
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

    /**
     * 在SpringMVC中，可以使用@RequestBody和@ResponseBody两个注解，分别完成请求报文到对象和对象到响应报文的转换，
     * 底层这种灵活的消息转换机制就是利用HttpMessageConverter来实现的，Spring内置了很多HttpMessageConverter，
     * 比如MappingJackson2HttpMessageConverter，StringHttpMessageConverter等，
     * 自定义自己的消息转换器来满足自己特定的需求有两种方式：
     * 1、使用spring或者第三方提供的现成的HttpMessageConverter
     * 2、自己重写一个HttpMessageConverter。
     * 消息转换器配置
     * HttpMessageConverter 在 HttpMessageConvertersAutoConfiguration 类中自动注册的
     * 相关类如下
     * GsonHttpMessageConverterConfiguration
     * JacksonHttpMessageConvertersConfiguration
     * JsonbHttpMessageConvertersConfiguration
     * HttpEncodingProperties
     * HttpMessageConverters
     *
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        //创建 FastJson 消息转换器 FastJsonHttpMessageConverter
//        FastJsonHttpMessageConverter fastjsonConverter = new FastJsonHttpMessageConverter();
//        //创建 FastJson 配置类
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastjsonConverter.setFastJsonConfig(fastJsonConfig);
//        //将 fastjsonConverter 添加到视图消息转换器列表
//        converters.add(fastjsonConverter);
    }

    /**
     * SpringMVC提供了一个特殊的视图解析器协调类 ContentNegotiatingViewResolver，
     * 它通过代理给不同的 ViewResolver 来处理不同的视图。通过覆盖重写 configureViewResolvers方法
     * 来配置视图解析器。
     */
    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
        registry.viewResolver(freeMarkerViewResolver());
    }
    @Bean
    FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".ftl");
        viewResolver.setCache(false);
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setRequestContextAttribute("requestContext");
        viewResolver.setOrder(0);
        viewResolver.setExposeRequestAttributes(true);
        viewResolver.setExposeSessionAttributes(true);
        return viewResolver;
    }

    //配置 FreeMarker 全局变量配置
    @Bean
    FreeMarkerConfigurer freeMarkerConfigurer() {
        /**
         * 等同于 application.yml 配置
         *   freemarker:
         *     enabled: true
         *     template-loader-path: classpath:/templates/ #模板加载路径 按需配置
         *     suffix: .ftl  #后缀名
         *     content-type: text/html
         *     charset: UTF-8 #编码格式
         *     request-context-attribute: request  #访问request
         *     cache: false #缓存配置
         *     settings:
         *       number_format: '0.##'   #数字格式化，无小数点
         */
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setDefaultEncoding("UTF-8");
        freeMarkerConfigurer.setTemplateLoaderPath("classpath:/templates/");
        freemarker.template.Configuration configuration = null;
        try {
            configuration = freeMarkerConfigurer.createConfiguration();
            configuration.setDefaultEncoding("UTF-8");
        } catch (TemplateException e) {
            logger.error("freemarker 配置 Bean TemplateException 异常", e);
        } catch (IOException e) {
            logger.error("freemarker 配置 Bean IOException 异常", e);
        }

        Map<String, Object> vars = new HashMap<>();
//        vars.put("rootContextPath", "ROOT");
//        ftl页面获取
//        <script src="${rootContextPath}/app/login.js"></script>
        freeMarkerConfigurer.setFreemarkerVariables(vars);
        return freeMarkerConfigurer;
    }


    /**
     * 跨域配置
     * 通过 CorsRegistry 添加路径映射
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        super.addCorsMappings(registry);

//        registry
//                //配置允许跨域的路径
//                .addMapping("/**")
//                //配置允许访问的跨域资源的请求域名
//                .allowedOrigins("*")
//                //配置允许访问该跨域资源服务器的请求方法
//                .allowedMethods("PUT,POST,GET,DELETE,OPTIONS")
//                //配置允许请求 header的访问
//                .allowedHeaders("*");
    }

    /**
     * SpringMVC接收HTTP请求会把请求参数自动绑定映射到 Controller请求参数上。
     * Spring中没有默认配置将字符串转换为日期类型,通过添加一个 Date Formatter类来实现自动转换。
     */
    @Override
    protected void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    /**
     * 拦截器配置
     * 通过 注册器InterceptorRegistry 添加 拦截器HandlerInterceptor
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
//        注册自定义拦截器，添加拦截路径和排除拦截路径
//        registry.addInterceptor(new LoginSessionInterceptor())
//                //拦截全部请求
//                .addPathPatterns("/**")
//                //放开以下请求内容
//                .excludePathPatterns(
//                        "/",
//                        "/**/*.js",
//                        "/**/*.css",
//                        "/**/*.png"
//                );
    }

    /**
     * 视图控制器配置
     */
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);

        registry.addViewController("/").setViewName("/index");
        //与以下代码逻辑相同
//        @GetMapping("/")
//        public String index() { return "index"; }
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/error/500").setViewName("/error/500");
    }

    /**
     * 静态资源配置
     * 默认将 classpath:/static classpath:/public classpath:/resources
     *       classpath:/META-INF/resources 文件夹映射为 /**
     * 使用 ResourceHandlerRegistry 注册 ResourceHandler，添加自定义静态资源路径映射
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
//        例：
//        registry.addResourceHandler("/app/**")
//                .addResourceLocations("classpath:/static/app");
    }
}
