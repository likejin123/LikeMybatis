package com.likejin.springmvc.controller;


/**

 1.地址映射
        RequestMapping(value="",method=RequestMethod.GET) = @GetMapping("")
 2.返回值
        RequestMapping
            当不配置视图解析器时，返回的字符串解析为请求/myweb/hello/success(走入sayHelloSuccess方法)
                相当于foward:/myweb/hello/success请求转发
            返回值通常解析为跳转路径
                返回String时，没有视图解析器则foward请求转发
                有视图解析器则返回视图
        ResponseBody
            返回结果不会被解析为跳转路径，而是直接写入 HTTP response body 中。


 */
 /**
 * @Author 李柯锦
 * @Date 2023/5/29 15:00
 * @Description 测试地址映射和返回值
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class TestAddrMappingController {
    @RequestMapping("/sayHello")
    public String sayHello(){
        System.out.println("helloWorld...");
        return "success";
    }
    @RequestMapping("/success")
    @ResponseBody
    public String sayHelloSuccess() {
        return "success";
    }

    @RequestMapping("/sayHelloBody")
    @ResponseBody
    public String sayHelloBody(){
        return "hello";
    }


}

