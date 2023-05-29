package com.likejin.spring.xml.service.impl;

import com.likejin.spring.xml.entity.Book;
import com.likejin.spring.xml.mapper.BookMapper;
import com.likejin.spring.xml.service.BookService;

import java.util.List;

/**
 * @Author 李柯锦
 * @Date 2023/5/28 14:36
 * @Description
 */
public class BookServiceImpl implements BookService {


    public BookMapper mapper;

    public void setMapper(BookMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Book> selectAll() {
        return mapper.selectAll();
    }
}
