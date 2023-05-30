package com.likejin.bootplus.testimpot.importsource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author 李柯锦
 * @Date 2023/5/30 20:56
 * @Description 测试@ImportResource注解
 */

@Configuration
@ImportResource(locations={"classpath:com/likejin/bootplus/testimpot/importsource/bean.xml"})
public class TestImportSource {
}
