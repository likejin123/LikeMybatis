package com.likejin.bootplus;

import com.likejin.bootplus.testimpot.import1.Person;
import com.likejin.bootplus.testimpot.importsource.TestImportSourceEntity;
import com.likejin.bootplus.testimpot.property.TestPropertySource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author 李柯锦
 * @Date 2023/5/30 20:40
 * @Description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestImport {

    @Resource
    TestPropertySource testPropertySource;

    /*
     * @Description 用于测试注解PropertySource绑定.properties的内容到属性上
     * @param
     * @return void
     **/
    @Test
    public void testPropertySource(){
        System.out.println(testPropertySource);
    }

    @Resource
    TestImportSourceEntity testImportSourceEntity;

    /*
     * @Description 测试通过ImportSource来导入xml文件的配置
     * @param
     * @return void
     **/
    @Test
    public void testImportSource(){
        System.out.println(testImportSourceEntity);
    }
    
    @Resource
    Person Person;
    
    /*
     * @Description 通过import导入实体类执行其重写selectImports的方法（实现ImportSelector，重写selectImports）
     * @param
     * @return void
     **/
    @Test
    public void testImport(){
        System.out.println(Person);
    }
}
