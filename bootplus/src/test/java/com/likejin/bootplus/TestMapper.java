/**
 1.MapperScan注解
     将指定包下的所有mapper编译时将接口根据mapper.xml生成相应的接口实现类，并且注入到容器中
        如果xml和类同包下并且名称相对应，不需要额外配置xml文件的位置
     mapper注解
        在编译时将包含mapper注解的接口根据mapper.xm生成相应的接口实现类，并且注入到容器中
            如果xml和类同包下并且名称相对应，不需要额外配置xml文件的位置
 2.xml中mapper-locations
    如果xml和类不同包下或者同包名称不对应
        那么需要额外配置xml文件的地址以便mapper扫描时根据xml文件生成代理实现类并注入容器
 */

package com.likejin.bootplus;

import com.likejin.bootplus.mapper.TBookMapper;
import com.likejin.bootplus.pojo.entity.TBook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 李柯锦
 * @Date 2023/5/30 19:51
 * @Description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapper {

    @Resource
    TBookMapper tBookMapper;

    /*
     * @Description 测试提供的sql语句
     * @param
     * @return void
     **/
    @Test
    public void TestCodeMapper(){
        TBook tBook = tBookMapper.selectById(1);
        System.out.println(tBook);
    }
    /*
     * @Description 测试自定义sql语句
     * @param
     * @return void
     **/
    @Test
    public void TestXmlMapper(){
        List<TBook> tBooks = tBookMapper.selectAll();
        for(TBook book : tBooks){
            System.out.println(book);
        }
    }
}
