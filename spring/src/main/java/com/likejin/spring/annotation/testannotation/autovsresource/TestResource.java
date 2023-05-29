package com.likejin.spring.annotation.testannotation.autovsresource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author 李柯锦
 * @Date 2023/5/28 21:40
 * @Description 测试resource
 */
@Component
public class TestResource {

    @Bean
    //类型为Man 名称为man
//    public Man man(){
    //类型为Man 名称为man2 testMan报错
    public Man man2(){
        return new Man();
    }
    @Bean
    //类型为Man 名称为man3
    public Man man3(){
        return new Man();
    }
    @Resource(name = "man2")
    //使用时，即先匹配id，找不到指定的就匹配类型，类型发现多个或匹配不上报错
            //报错解决：指定id（多个类型）
    public Man man;

    public void testMan(){
        System.out.println(man);
    }



}

