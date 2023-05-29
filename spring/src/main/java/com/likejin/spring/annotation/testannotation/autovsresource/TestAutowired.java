package com.likejin.spring.annotation.testannotation.autovsresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author 李柯锦
 * @Date 2023/5/28 21:30
 * @Description 测试autowired
 */

@Component
public class TestAutowired {

    @Bean
    //类型为Man 名称为man
//    public Man man(){
    //类型为Man 名称为man0 testMan报错
    public Man man0(){
        return new Man();
    }
    @Bean
    //类型为Man 名称为man1
    public Man man1(){
        return new Man();
    }
    @Autowired
    @Qualifier(value = "man1")
    //根据类型匹配到多个Man。。然后根据名称可以匹配到 id 为man的对象，如果没有报错
        //报错解决：更改注入的id 选择一个等于这个
        //报错解决：@Qualifier(value = "man1") 指定注入对象的id
    public Man man;

    public void testMan(){
        System.out.println(man);
    }


}
