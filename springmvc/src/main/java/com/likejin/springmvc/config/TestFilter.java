/**
 1.过滤器解决乱码问题
    1.解决方案一：配置springmvc自定义编码过滤器
        org.springframework.web.filter.CharacterEncodingFilter
    2.解决方案二：自定义过滤器实现Filter接口
         <filter>
             <filter-name>encoding</filter-name>
             <filter-class>com.likejin.springmvc.config.TestFilter</filter-class>
         </filter>
         <filter-mapping>
             <filter-name>encoding</filter-name>
             <url-pattern>/*</url-pattern>
         </filter-mapping>
 2.过滤器可以过滤路径为/*的所有请求


 */
package com.likejin.springmvc.config;


import javax.servlet.*;
import java.io.IOException;

/**
 * @Author 李柯锦
 * @Date 2023/5/29 18:48
 * @Description 测试过滤器
 */
public class TestFilter implements Filter{



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("执行过滤器初始化方法");

    }
  //在方法doFilter中的chain.doFilter(request, response)最终是调用Servlet的doService()方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("执行过滤器doFilter");
    }

    @Override
    public void destroy() {
        System.out.println("执行过滤器destroy");
    }
}
