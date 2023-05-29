package com.likejin.spring.annotation.mapper;

import com.likejin.spring.xml.entity.Book;

import java.util.List;

/**
 * @Author 李柯锦
 * @Date 2023/5/24 19:32
 * @Description Book实体类的dao层
 */
public interface BookMapper {

    /*
     * @Description 查询全部的书。注意：resultType不是list，而是book
     * @param
     * @return List<Book>
     **/
    List<Book> selectAll();


}
