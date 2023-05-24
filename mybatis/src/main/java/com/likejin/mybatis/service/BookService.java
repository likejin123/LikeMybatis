package com.likejin.mybatis.service;

import com.likejin.mybatis.entity.Book;

import java.util.List;

/**
 * @Author 李柯锦
 * @Date 2023/5/24 19:42
 * @Description
 */
public interface BookService {

    List<Book> selectAll();

    List<Book> selectByIdAndStock(Integer id,Integer stock);

    Integer Insert(Book book);

    List<Book> selectByIdOrStocke( Integer id,  Integer stock);

    List<Book> selectByIdAndStockOrSales(Integer id,  Integer sales,  Integer stock);

    List<Book> selectByBookAndUser();
}
