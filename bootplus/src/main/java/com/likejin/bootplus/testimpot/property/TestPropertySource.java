package com.likejin.bootplus.testimpot.property;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author 李柯锦
 * @Date 2023/5/30 20:37
 * @Description 测试注解@
 */

//@Data @value无需此注解，@ConfigurationProperties需要此注解
@ToString
@Configuration
//@ConfigurationProperties(prefix = "user")//可以不使用前缀，直接根据名称匹配set方法
@PropertySource("classpath:com/likejin/bootplus/testimpot/property/propertySource.properties")
public class TestPropertySource {

    @Value("${user.id}")
    Integer id;


}
