

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class CodeGenerator {
    @Test
    public void genCode() {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("Likejin");
        //open等于true时，生成完代码后，打开资源管理器
        gc.setOpen(false); //生成后是否打开资源管理器
        //去掉service接口前缀I
        gc.setServiceName("%sService");	//去掉Service接口的首字母I
        //自增策略
        gc.setIdType(IdType.AUTO); //主键策略
        //自动生成接口文档@API
        gc.setSwagger2(false);//开启Swagger2模式
        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/book?serverTimezone=GMT%2B8&characterEncoding=utf-8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("abc123");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.likejin.bootplus");
        pc.setEntity("pojo.entity"); //此对象与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。
        mpg.setPackageInfo(pc);

        // 5、策略配置
        //能够完成数据库表名从下划线到类的驼峰习惯
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略


        //能够完成数据库字段名从下划线到类的属性驼峰习惯
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        //使用lombok的注解修饰
        strategy.setEntityLombokModel(true); // lombok
        //生成逻辑删除字段名
        strategy.setLogicDeleteFieldName("is_deleted");//逻辑删除字段名
        //符合阿里巴巴规范，去掉is前缀
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);//去掉布尔值的is_前缀（确保tinyint(1)）

        //和controller的生成有关，全部使用@RestController
        strategy.setRestControllerStyle(true); //restful api风格控制器,restController返回json数据
        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }
}


