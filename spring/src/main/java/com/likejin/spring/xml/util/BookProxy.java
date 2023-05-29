package com.likejin.spring.xml.util;

import com.likejin.spring.xml.mapper.BookMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @Author 李柯锦
 * @Date 2023/5/28 14:48
 * @Description bookMapper的代理实现类
 */
public class BookProxy {

    public static BookMapper getStaticBookMapper() {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder()
                        .build(BookProxy.class.getClassLoader()
                        .getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookProxy = sqlSession.getMapper(BookMapper.class);;
        return bookProxy;
    }

    public BookMapper getBookMapper() {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder()
                        .build(BookProxy.class.getClassLoader()
                                .getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookProxy = sqlSession.getMapper(BookMapper.class);;
        return bookProxy;
    }
}
