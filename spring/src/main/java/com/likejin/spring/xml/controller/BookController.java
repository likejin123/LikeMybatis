package com.likejin.spring.xml.controller;

import com.likejin.spring.xml.entity.Book;
import com.likejin.spring.xml.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author 李柯锦
 * @Date 2023/5/28 14:38
 * @Description 测试bean
 */
public class BookController {

    //初始化spring容器
    static ClassPathXmlApplicationContext container =
            new ClassPathXmlApplicationContext("com/likejin/spring/xml/xmlconfig/context.xml");


    public static void main(String[] args) {
        testXml();

    }

    /*
     * @Description 测试xml文件配置bean
     * @param
     * @return void
     **/
    public static void testXml(){
        //测试注入过程
        BookService bookService =(BookService) container.getBean("bookService");
        List<Book> books = bookService.selectAll();
        for(Book book : books){
            System.out.println(book);
        }
        //测试book注入
        //set注入
//        book{id=null, name='老人与海', price=null, author='海明威', sales=null, stock=null, imgPath='null'}
        Book book = (Book)container.getBean("book");
        System.out.println(book);
        //构造器注入（提供全参）
//        book{id=500, name='老人与海1', price=50, author='海明威', sales=50, stock=50, imgPath='无'}
        Book book1 = (Book)container.getBean("book1");
        System.out.println(book1);
        //properties注入
        Book book2 = (Book)container.getBean("book2");
        System.out.println(book2);
    }


}
