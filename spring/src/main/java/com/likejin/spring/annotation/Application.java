/**
一.全部注解
    1.扫描
    ComponentScan：
        将自己定义的bean注册到容器中
    2.注入对象
    bean：
        类：
            1.configvscomponen
                配置类
                内部的配置对象会被复用。。
                即内部方法调用的对象是如果是本类方法的注入，那么直接用一个，不会再创建对象
            2.component
                （通用组件）
            3.Repository
                （数据访问层）
            4.Service
                (业务逻辑层）
            5.Controller(控制层)
                 应用在MVC层（控制层）,DispatcherServlet会自动扫描注解了此注解的类，然后将web请求映射到注解了@RequestMapping的方法上。
        方法：
            1.Bean
    3.依赖注入
    DI:
        1.Autowired
            按类型完成装配
        2.Resourced
            先按名称装配，再按类型装配
         3.value
            赋值简单类型
 二.对比
    1.Configuration和Component
        内部对象是否可重复利用
            Configuration的内部bean调用另一个方法时，另一个bean则会直接注入方法中创建的。
            Component创建多个bean
    2.Autowrided和Resource
        Autowired
            使用时，即先类型匹配，类型发现多个再id匹配，id匹配不上报错
        Resource
            使用时，即先匹配id，找不到指定的就匹配类型，类型发现多个或匹配不上报错
    3.注入时
        两个id相同类型相同的对象会被Overriding
    4.Repository(dao)，Service(service)，Controller(controller)
        repository
            repository的类上如果数据库操作中抛出了异常，就能对其进行处理，
            转而抛出的是翻译后的spring专属数据库异常，方便我们对异常进行排查处理
        service
            处理业务逻辑
        controller
            注解的bean会被spring-mvc框架所使用

 */


package com.likejin.spring.annotation;

import com.likejin.spring.annotation.testannotation.configvscomponen.TestComponent;
import com.likejin.spring.annotation.testannotation.configvscomponen.TestConfiguration;
import com.likejin.spring.annotation.controller.BookController;
import com.likejin.spring.annotation.testannotation.autovsresource.TestAutowired;
import com.likejin.spring.annotation.testannotation.autovsresource.TestResource;
import com.likejin.spring.xml.entity.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author 李柯锦
 * @Date 2023/5/28 20:32
 * @Description 主测试类
 */

public class Application {




    public static void main(String[] args) {
//        testAllAnnotation();
//        testComponentAndConfiguration();
        testAutowiredAndResource();
    }


    public static ClassPathXmlApplicationContext container =
            new ClassPathXmlApplicationContext("com/likejin/spring/annotation/xmlconfig/context.xml");


    /*
     * @Description 测试autowired和resource
     * @param
     * @return void
     **/
    public static void testAutowiredAndResource(){
        TestAutowired testAutowired =(TestAutowired) container.getBean("testAutowired");
        testAutowired.testMan();
        TestResource testResource =(TestResource) container.getBean("testResource");
        testResource.testMan();
    }

    /*
     * @Description 测试configuration和component的区别（注意 TestConfiguration和TestComponent两者不能同时存在，会注入多个同类型的bean）
     * @param
     * @return void
     **/
    public static void testComponentAndConfiguration(){
        //两者不能都存在，注入car和person发生错误
        TestConfiguration testConfiguration =(TestConfiguration) container.getBean("testConfiguration");
        testConfiguration.testEquals();
        TestComponent testComponent =(TestComponent) container.getBean("testComponent");
        testComponent.testEquals();

    }


    /*
     * @Description 测试所有注解的可用
     * @param
     * @return void
     **/
    public static void testAllAnnotation(){
        //可以根据id匹配（默认首字母小写） 也可以根据类型匹配
        BookController bookController = (BookController)container.getBean("bookController");
        List<Book> books = bookController.getBook();
        for(Book book : books){
            System.out.println(book);
        }
    }

}
