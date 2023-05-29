/**
 1.DispatcherServlet(/) controller和地址解析器转发或者返回数据
    JspServlet(*.jsp)   处理.jsp后缀的资源
    DefaultServlet(/)   处理静态资源
        此时根据精确匹配法顺序为，即由于default被覆盖，无法访问静态资源
             JspServlet(*.jsp)
             DispatcherServlet(/)
             DefaultServlet(/)
        即可以访问首页，可以访问controller，无法访问静态资源（No mapping for GET /myweb/html/success.html）
 2.DispatcherServlet(/*) controller和地址解析器转发或者返回数据
     JspServlet(*.jsp)   处理.jsp后缀的资源
     DefaultServlet(/)   处理静态资源
        此时根据精确匹配法顺序为，即由于jsp和静态资源serlvet都被覆盖，无法访问除了controller以外的其他资源
        如果controller此时返回jsp利用地址解析器，则地址解析器返回jsp页面也会经过DispatcherServlet无法发文
            DispatcherServlet(/*)
            JspServlet(*.jsp)
            DefaultServlet(/)
        即无法访问首页（ No mapping for GET /myweb/index.jsp），
        可以访问controller
        无法利用视图解析器返回jsp（No mapping for GET /myweb/WEB-INF/jsp/success.jsp）
        即无法访问静态资源（No mapping for GET /myweb/html/success.html）
 3.无法访问静态资源时
        配置静态资源处理，请求先经过该默认servlet，不能处理再给DispacherServlet
        mvc:default-servlet-handler
 4.jsp是动态资源，html，css等为静态资源
 5.
    /表示匹配所有请求（其中包含除.jsp和.jspx外的所有后缀）
    /*表示匹配所有请求（包含所有后缀）
    即如果配置/*访问不到jsp。。
 6.重点！！！
    总结
    如果DispatcherServlet配置为/，则匹配所有请求除了jsp，即静态资源无法访问。
    如果DispatcherServlet配置为/*，则匹配所有请求包括jsp，则静态资源和jsp都无法访问。
    静态资源访问方法：默认servlet,DispacherServlet处理不了交给他
        <mvc:default-servlet-handler></mvc:default-servlet-handler>

 */
package com.likejin.springmvc.controller;

/**
 * @Author 李柯锦
 * @Date 2023/5/29 15:08
 * @Description 测试tomcat的两个servlet和dispacherServlet的执行顺序
 */
public class TestServletOrderController {
}
