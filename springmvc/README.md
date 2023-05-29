# 一.springmvc的执行顺序

Model View Controller：模型（数据） 视图（显示） 控制器（交互）

mvc单体架构

```java
前后端一体：ModelAndVieww jsp controller
框架：SSM
打包war包在tomcat上运行即可
```

改进mvc前后端分离架构：

```java
前后端分离：JSON vue controller
```

微服务架构。。。

## 1.过滤器拦截器controller

+ Filter pre-->doService-->Dispacher-->PreHandle-->Controller-->PostHandle-->afterComletion-->Filter after
+ 过滤器拦截执行chain.doFilter放行
+ springmvc的doService方法，然后通过Dispacher分发controller
+ 拦截器执行preHandle方法
+ 执行controller具体方法
+ 拦截器执行PostHandle（controller执行完毕），afterComletion（model渲染完毕）方法
+ 拦截器拦截执行after方法

## 2.整体流程

+ Tomcat配置了DispacherServlet和默认servlet和jspServlet
+ 客户端请求被Tomcat监听到并使用DispacherServlet处理
+ DispacherServlet根据URL寻找Handler（controller）业务处理
+ Handler处理完成后生成ModelAndView对象返回给DispacherServlet
+ DispacherServlet根据ModelAndView对象传给ViewResolver视图解析器，请求进行视图解析
+ 视图解析器生成物理视图View后返回给DispacherServlet
+ DispacherServlet根据View进行视图渲染（数据模型填充视图）
+ DispacherServlet将渲染后的视图返回给客户端

# 二.测试细节

+ 1.测试过滤器拦截器的使用

+ 2.测试三个servlet的配合使用

  ````java
  JspServlet(*.jsp)
  DispatcherServlet(/)
  DefaultServlet(/)
  ````

+ 3.测试springmvc的注解

```java
地址映射：@RequestMapping @GetMapping @PostMapping..
参数：@RequestParam @Pathvariable @RequetBody
返回值：@RequestMapping @ResponseBody 
模型：model和view的配合（model在controller中，view在jsp中）
```

+ 4.springmvc的测试流程

```java
1. 编写web.xml
初始化springmvc提供的DispacherServlet和地址映射关系（用配置文件初始化）
    可以配置过滤器（统一编码）
2. 编写springmvc.xml
   spring注解扫描
   mvc请求转发
   默认servlet（防止静态资源无法访问）
   页面解析器（mvc的controller处理后返回视图位置）
   配置拦截器（针对特定地址）
3. 编写controller处理即可。。
```



