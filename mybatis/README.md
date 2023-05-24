# 一.文档结构

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

## 2.sql绑定(具体测试在controller中)

+ 多参数
+ 插入时的主键自增策略
+ 动态sql if
+ 动态sql choose when otherwise
+ 多表联查
+ 一级缓存和二级缓存

​		

