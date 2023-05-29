package com.likejin.springmvc.controller;
/**

 1.PathVariable   get方法  路径参数
 2.RequestParam   get方法  url参数
 3.RequestBody    post方法 请求体参数
 4.约定中，GET 方法的参数应该放在 url 中，POST 方法参数应该放在 body 中
    实际中 post也可以将参数放到路径中。。
            get也可以将参数放到请求体中。。
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 李柯锦
 * @Date 2023/5/29 15:39
 * @Description 测试参数
 */
@Controller
@RequestMapping("/param")
public class TestParamController {

    // /pathVariable/123
    @GetMapping("/pathVariable/{id}")
    public void testPathVariable(@PathVariable("id") Integer id){
        System.out.println(id);
    }
    //  /requestParam?id=1
    @GetMapping("/requestParam")
    public void testRequestParam(@RequestParam("id") Integer id){
        System.out.println(id);
    }
    //  /requestBody  参数放在请求体中 1
    @PostMapping("/requestBody")
    public void testRequesyBody(@RequestBody String id){
        System.out.println(id);
    }
    //  /postRequestParam?id=1
    @PostMapping("/postRequestParam")
    public void testpostRequestParam(@RequestParam("id") Integer id){
        System.out.println(id);
    }
    //  /getRequestBody 参数放在请求体中
    @GetMapping("/getRequestBody")
    public void testGetRequestBody(@RequestBody String id){
        System.out.println(id);
    }

}
