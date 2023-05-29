package com.likejin.spring.annotation.testannotation.configvscomponen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 李柯锦
 * @Date 2023/5/28 20:48
 * @Description 测试configuration（注释掉TestComponent）
 */

@Configuration
public class TestConfiguration {

    @Bean
    public Person getPerson(){
        Person person = new Person();
        person.car = getCar();
        return person;
    }

    @Bean
    public Car getCar(){
        return new Car();
    }


    @Autowired
    public Car car;
    @Autowired
    public Person person;

    public void testEquals(){
        System.out.println(car == person.car);

    }
}

