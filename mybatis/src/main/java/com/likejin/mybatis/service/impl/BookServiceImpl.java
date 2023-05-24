package com.likejin.mybatis.service.impl;

import com.likejin.mybatis.entity.Book;
import com.likejin.mybatis.mapper.BookMapper;
import com.likejin.mybatis.service.BookService;
import com.likejin.mybatis.util.MyBatisUtil;

import java.util.List;

/**
 * @Author 李柯锦
 * @Date 2023/5/24 19:42
 * @Description
 */
public class BookServiceImpl implements BookService {

    public BookMapper bookMapper = MyBatisUtil.getProxyMapper(BookMapper.class);

    @Override
    public List<Book> selectAll() {
        return bookMapper.selectAll();
    }

    @Override
    public List<Book> selectByIdAndStock(Integer id, Integer stock) {
        return bookMapper.selectByIdAndStock(id,stock);
    }

    @Override
    public Integer Insert(Book book) {
        return bookMapper.Insert(book);
    }

    @Override
    public List<Book> selectByIdOrStocke(Integer id, Integer stock) {
        return bookMapper.selectByIdOrStocke(id,stock);
    }

    @Override
    public List<Book> selectByIdAndStockOrSales(Integer id, Integer sales, Integer stock) {
        return  bookMapper.selectByIdAndStockOrSales(id,sales,stock);
    }

    @Override
    public List<Book> selectByBookAndUser() {
        return bookMapper.selectByBookAndUser();
    }
}
