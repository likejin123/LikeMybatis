/**

 1.测试多参数的绑定
    不使用@Param报错 Parameter 'id' not found. Available parameters are [arg1, arg0, param1, param2]
        更改sql参数 arg0 arg1
    解释：如果不使用@Param注解，在编译时将方法参数编译为 [arg1, arg0, param1, param2] ，sql语句无法注入参数。
 2.测试插入时主键自增策略
    不使用useGeneratedKeys="true" keyProperty="id"策略,id参数为null 不报错，id自增由数据库管理
            sql：insert into t_book VALUES (NULL,?,?,null,null,null,null) 参数为null
    不使用useGeneratedKeys="true" keyProperty="id"策略,id参数为#{id}传入null 不报错，id自增由数据库管理
            sql：insert into t_book VALUES (?,?,?,null,null,null,null) 参数为null
    加入useGeneratedKeys="true" keyProperty="id" 不报错，id自增由数据库管理
            sql：insert into t_book VALUES (?,?,?,null,null,null,null) 参数为null
 3.测试条件查询多if
    id = null where拼接错误  Preparing: select * from t_book where and stock > 10
    解决方式：用<where></> 如果后面都没有则不加，如果有则会去掉多余的and 和 or
 4.测试多条件查询choose when when otherwise结构
    动态拼接sql
        sql：select * from t_book WHERE id > ?
    resultType 即将结果的map封装到实体类中（用于解决数据库字段和实体类成员变量名称不同问题）
        解决方法：
            sql起别名
            全局下划线转驼峰
            resultType转换
    注意：mybatis执行方式是先把所有结果放入hashmap中，然后再将对应字段赋值给实体类（利用的是set方法）
 5.测试两表联查返回实体对象
    封装结果
    理解：select 前面的别名 user.xxx 不算列的别名 结果字段名仍然是xxx 故如果有两个xxx 结果会有两列字段相同的xxx 需要起别名
    注意：返回的sql结果中如果有别名 user.xxx，但是在结果集映射中只写xxx

 6.测试一级和二级缓存
    一级缓存是sqlsession级别，
    二级缓存是sqlsessionFactory级别。
    如果一级缓存没有命中，就去二级缓存中查询，二级缓存中也没有命中，就在数据库中查询
    默认开启一级缓存。。如果同一个sqlsession发起请求，则直接返回不执行sql。，
        同一个sqlsession查询两次只执行一次sql
        不同的sqlsession查询执行了两次sql
    开启二级缓存，且需要对象序列化，且需要提交
        同一个sqlsessionFactory创建的不同sqlsession
        不同sqlsession查询只执行了一个sql
 7.分页插件
    解析sql语句。（获取页数据，获取当前页数据）
        被解析语句：select * from t_book (分页 2  5)
            解析结果：SELECT count(0) FROM t_book （计算分页数据）
                        select * from t_book LIMIT ?, ? 5(Long), 5(Integer) （查询当前页数据）
    结果封装到pageInfo中
 */

package com.likejin.mybatis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.likejin.mybatis.entity.Book;
import com.likejin.mybatis.mapper.BookMapper;
import com.likejin.mybatis.service.BookService;
import com.likejin.mybatis.service.impl.BookServiceImpl;
import com.likejin.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author 李柯锦
 * @Date 2023/5/24 19:43
 * @Description 模拟调用bookservice的controller
 */
public class BookController {

    public static BookService bookService = new BookServiceImpl();

    public static void main(String[] args) {
        //testPass();
        //testParam();
        //testIdIncrement();
        //testSQLIF();
        //testChoose();
        //testTwoFormSelect();
        //testCache1();
        //testCache2();
        testPage();
        MyBatisUtil.close();
    }
    /*
     * @Description 负责测试是否能查通数据库
     * @param
     * @return void
     **/
    public static void testPass(){
        List<Book> books = bookService.selectAll();
    }

    /*
     * @Description 测试多参数的绑定
     * @param
     * @return void
     **/
    public static void testParam(){
        List<Book> books = bookService.selectByIdAndStock(10, 100);
        for(Book book : books){
            System.out.println(book);
        }
    }

    /*
     * @Description 测试主键自增传入参数为Null
     * @param
     * @return void
     **/
    public static void testIdIncrement(){
        bookService.Insert(new Book(null,"阿衰",new BigDecimal("10.0"),"like",null,null,null));
        MyBatisUtil.commit();
    }

    /*
     * @Description 测试动态sql的if和<where>的使用
     * @param
     * @return void
     **/
    public static void testSQLIF(){
        bookService.selectByIdOrStocke(null,10);
        bookService.selectByIdOrStocke(10,null);
    }

    /*
     * @Description 测试动态sql choose和resultType的使用
     * @param
     * @return void
     **/
    public static void testChoose(){
        List<Book> books = bookService.selectByIdAndStockOrSales(10, null, 100);
        for(Book book : books){
            System.out.println(book);
        }
    }

    /*
     * @Description 两表联查测试
     * @param
     * @return void
     **/
    public static void testTwoFormSelect(){
        List<Book> books = bookService.selectByBookAndUser();
        for(Book book : books){
            System.out.println(book);
        }
    }



    /*
     * @Description 测试一级缓存(同一个sqlSession)
     * @param null
     * @return null
     **/
    public static void testCache1(){
        List<Book> books = bookService.selectAll();
        List<Book> books1 = bookService.selectAll();
    }

    /*
     * @Description 测试二级缓存（同一个sqlsession，不同sqlsessionFactory）
     * @param
     * @return void
     **/
    public static void testCache2(){
        List<Book> books = bookService.selectAll();
        //注意二级缓存需要提交后生效
        MyBatisUtil.commit();
        //不同的sqlsession查询 同一个SqlsessionFactory
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.sqlSessionFactory;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<Book> books1 = mapper.selectAll();
    }


    /*
     * @Description 测试分页插件功能
     * @param
     * @return void
     **/
    public static void testPage(){
        PageHelper.startPage(2,5);
        //紧跟的第一个select方法会被分页
        List<Book> books = bookService.selectAll();
        //
        PageInfo pageInfo = new PageInfo(books);
        List<Book> list = pageInfo.getList();
        for(Book book : list){
            System.out.println(book);
        }
        System.out.println("当前页码" + pageInfo.getPageNum());
        System.out.println("总页码" + pageInfo.getPages());
    }
}
