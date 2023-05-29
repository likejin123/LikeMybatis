package com.likejin.spring.annotation.testannotation.configvscomponen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author 李柯锦
 * @Date 2023/5/28 21:00
 * @Description 测试component（注释掉TestConfiguration）
 */

@Component
public class TestComponent {

    @Bean
    public Person getPerson1(){
        Person person = new Person();
        person.car = getCar1();
        return person;
    }

    @Bean
    public Car getCar1(){
        return new Car();
    }


    @Autowired
    @Qualifier("getCar1")
    public Car car;
    @Autowired
    @Qualifier("getPerson1")
    public Person person;

    public void testEquals(){
        System.out.println(car == person.car);
    }
}
