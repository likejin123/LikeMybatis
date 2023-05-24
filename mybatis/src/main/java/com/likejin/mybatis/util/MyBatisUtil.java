package com.likejin.mybatis.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @Author 李柯锦
 * @Date 2023/5/24 19:34
 * @Description 初始化sqlsession，提供获得实体类的方法
 */
public class MyBatisUtil {

    public static SqlSessionFactory sqlSessionFactory;

    static{
        InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    public static SqlSession sqlSession;

    static{
        //参数为是否开启自动提交，是否使用默认连接池，设置事务级别
        sqlSession = sqlSessionFactory.openSession();
    }

    public static <T> T getProxyMapper(Class<T> clazz){
        return sqlSession.getMapper(clazz);
    }
    //mybatis-config中设置JDBC事务级别，手动提交
    public static void commit(){
        sqlSession.commit();
    }
    public static void close(){
        sqlSession.close();
    }
}
