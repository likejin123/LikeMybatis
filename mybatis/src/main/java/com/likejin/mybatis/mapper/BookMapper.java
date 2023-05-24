package com.likejin.mybatis.mapper;

import com.likejin.mybatis.entity.Book;
import org.apache.ibatis.annotations.Param;

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


    /*
     * @Description 查询大于id大于stock的全部书（测试param）
     * @param id
 * @param stock
     * @return List<Book>
     **/
    List<Book> selectByIdAndStock(Integer id,Integer stock);



    /*
     * @Description 插入一本书（测试主键自增）
     * @param book
     * @return Integer
     **/
    Integer Insert(Book book);


    /*
     * @Description 测试多if和标签where
     * @param id
     * @param stock
     * @return List<Book>
     **/
    List<Book> selectByIdOrStocke(@Param("id") Integer id, @Param("stock") Integer stock);


    /*
     * @Description 测试choose when when otherwise和resultType的使用
     * @param id
     * @param sales
     * @param stock
     * @return List<Book>
     **/
    List<Book> selectByIdAndStockOrSales(@Param("id") Integer id,@Param("sales") Integer sales,@Param("stock") Integer stock);

    /*
     * @Description user表和book表联查封装book
     * @param 
     * @return List<Book>
     **/
    List<Book> selectByBookAndUser();
}
