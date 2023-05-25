# 一.文档结构
## 1.文档结构

```java

.
|-- java
|   `-- com
|       `-- likejin
|           `-- mybatis
|               |-- controller
|               |   `-- BookController.java		'核心测试mybatis'	
|               |-- entity
|               |   |-- Book.java
|               |   `-- User.java
|               |-- mapper
|               |   |-- BookMapper.java
|               |   `-- xml
|               |       `-- BookMapper.xml		'核心sql语句'
|               |-- service
|               |   |-- BookService.java	
|               |   `-- impl
|               |       `-- BookServiceImpl.java	
|               `-- util
|                   `-- MyBatisUtil.java
`-- resources
    |-- jdbc.properties
    |-- log4j.properties
    `-- mybatis-config.xml
```

## 2.mybatis食用流程
+ 1.写pom
    + sql驱动依赖
    + mybatis核心依赖
    + （log4j依赖）

+ 2.主配置
    + 类别名
    + 数据源（jdbc.properties）
    + 注册mapper.xml
+ 3.写mapper
    + mapper接口类 定义方法
    + mapper.xml唯一标识接口类中的方法的sql语句
+ 4.启动
    + 根据配置文件创建sqlsessionFactory
    + 根据sqlsessionFactory创建sqlsession
    + 根据sqlsession获得mapper接口类的代理实现类
    + 代理实现类调用对应的方法完成数据库CRUD
    + 关闭sqlsession

# 二.功能

## 1.mybatis功能完整性

+ maven导入sql驱动，mybatis核心包，log4j日志
+ resources下的数据库连接，日志配置，mybatis核心配置

# 三.mybatis要点统计

## 1.mybatis核心配置

+ mappers 标签 

  + mapper resource 指明具体的xml文件位置

  + package name 指明具体的mapper位置（xml文件位置必须和mapper位置相同）

    xml放在resources中则自动打包。xml放在java下需要配置maven打包方式。打包方式为覆盖，即配置后需要将resources也配置到build resources
+ environment
    + id 可以配置多个环境 mysql Oracle
    + transactionManager 事务管理器  JDBC | MANAGED | 自定义
        +  JDBC :手动提交和回滚。依赖于数据源的到的连接控制 sqlsession
        +  MANAGED：mybatis不管理事务，程序的容器（JBOSS,WebLogic）来实现对事务的管理
        +  自定义：实现TransactionFactory接口，type指定为全类名
    + dataSource 数据源  POOLED | UNPOOLED | JNDI | 自定义
        + POOLED：使用连接池 mybatis数据库连接池
        + UNPOOLED：不使用连接池 
        + JNDI：在 EJB 或应用服务这类容器中查找指定的数据源
        + 自定义：实现 DataSourceFactory 接口，定义数据源的获取方式，type是全类名

## 2.sql绑定(具体测试在controller中)

+ 多参数
+ 插入时的主键自增策略
+ 动态sql if
+ 动态sql choose when otherwise
+ 多表联查
+ 一级缓存和二级缓存

​		

