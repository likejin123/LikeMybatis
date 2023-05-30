package com.likejin.bootplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
springboot:
 1.启动类注解
     SpringBootApplication
            SpringBootConfiguration
                标注当前类是配置类
            EnableAutoConfiguration
                configuration注解标注的配置都加载到当前SpringBoot创建并使用的IoC容器。
            ComponentScan
                扫描指定的包，默认扫描启动类所在的包下所有
 2.controller组件
     RestController
            controller + responsebody
 3.导入配置文件
     PropertySource
            一般搭配Configuration或者component使用
            加载.properties文件或者.yml文件
                搭配ConfigurationProperties实现绑定 需要提供属性的set方法
                搭配value${}初始化属性 无需set方法
     ImportResource
            一般搭配Configuration或者component使用
            加载.xml文件，让xml配置文件中的内容生效
                如可以在xml中配置bean生效
     Import
            一般搭配Configuration或者component使用
            可以将一个类不实现接口则作为bean导入当前应用的IOC容器中
                如果bean（不导入）实现了接口ImportSelector，那么调用selectImports方法将返回的String中的全类名注入为bean
                如果bean（不导入）实现了接口ImportBeanDefinitionRegistrar，那么调用registerBeanDefinitions方法

 4.事务管理
     Transactional
            使用spring的aop来在代码运行处加入一个代理对象
            代理对象会操作拦截器TransactionInterceptor 是否拦截
            代理对象会操作拦截器TransactionInterceptor最终操作数据源 DataSource提交或回滚事务
 5.全局异常处理
     ControllerAdvice（restcontrollerAdivce返回结果，controlleradvice跳转视图）
            类上，作用于控制层的异常处理，直接返回结果给前端。
     ExceptionHandler
            方法上，匹配参数中的异常，匹配成功则由该方法处理该异常。
mybatis
 1.MapperScan注解（等于多个mapper注解）
     将指定包下的所有mapper编译时将接口根据mapper.xml生成相应的接口实现类，并且注入到容器中
        如果xml和类同包下并且名称相对应，不需要额外配置xml文件的位置
     mapper注解
        在编译时将包含mapper注解的接口根据mapper.xm生成相应的接口实现类，并且注入到容器中
            如果xml和类同包下并且名称相对应，不需要额外配置xml文件的位置
 2.xml中mapper-locations
        如果xml和类不同包下或者同包名称不对应
            那么需要额外配置xml文件的地址以便mapper扫描时根据xml文件生成代理实现类并注入容器
  */

/**
 * @Author 李柯锦
 * @Date 2023/5/30 19:51
 * @Description
 */

@MapperScan("com.likejin.bootplus.mapper")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
