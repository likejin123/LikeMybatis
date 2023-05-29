
package com.likejin.spring.annotation.controller;

import com.likejin.spring.xml.entity.Book;
import com.likejin.spring.xml.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @Author 李柯锦
 * @Date 2023/5/28 14:38
 * @Description 测试自动注入
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    public List<Book> getBook(){
        return  bookService.selectAll();

    }
}
