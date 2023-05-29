package com.likejin.spring.annotation.service;

import com.likejin.spring.xml.entity.Book;

import java.util.List;

/**
 * @Author 李柯锦
 * @Date 2023/5/28 14:35
 * @Description book的service层
 */
public interface BookService {
    List<Book> selectAll();

}
