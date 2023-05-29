package com.likejin.springmvc.config;
/**
 1.配置拦截器
    只拦截指定路径
        配置拦截器作用的路径
         <mvc:interceptor>
             <mvc:mapping path="/hello/**"/>
             <bean class="com.likejin.springmvc.config.TestIntercepter"></bean>
         </mvc:interceptor>
    拦截全部路径
         <mvc:interceptor>
            <bean class="com.likejin.springmvc.config.TestIntercepter"> </bean>
         </mvc:interceptor>
 2.注意拦截器只会拦截配置的DispacherServlet的路径 jsp和静态资源不会拦截
  */

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 李柯锦
 * @Date 2023/5/29 19:02
 * @Description 拦截器
 */
public class TestIntercepter implements HandlerInterceptor {

    /*
     * @Description 该方法在controller执行之前调用
     * @param request
     * @param response
     * @param handler
     * @return boolean
     **/
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行拦截器的preHandle方法");
        return true;
    }

    /*
     * @Description 该方法在controller执行之后调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @return void
     **/
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("执行拦截器的postHandle方法");
    }

    /*
     * @Description 该方法在DispacherServlet执行结束之后调用（渲染页面结束后）
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return void
     **/
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("执行拦截器的afterCompletion方法");
    }
}
