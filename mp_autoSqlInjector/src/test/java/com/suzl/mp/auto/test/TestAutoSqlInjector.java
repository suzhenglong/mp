package com.suzl.mp.auto.test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.suzl.mp.auto.beans.User;
import com.suzl.mp.auto.mapper.EmployeeMapper;
import com.suzl.mp.auto.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @author: zhenglongsu@163.com
 * @date: 2018.08.15 09:30
 */
public class TestAutoSqlInjector {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = ctx.getBean("employeeMapper", EmployeeMapper.class);

    UserMapper userMapper = ctx.getBean("userMapper", UserMapper.class);


    /**
     * 测试公共字段填充
     */
    @Test
    public void testMetaObjectHandler2() {
        User user = new User();
        //user.setName("Tom");

        user.setId(3);
        user.setLogicFlag("1");
        userMapper.updateById(user);
    }

    /**
     * 测试公共字段填充
     */
    @Test
    public void testMetaObjectHandler1() {
        User user = new User();

        user.setLogicFlag("1");
        userMapper.insert(user);
    }

    /**
     * 测试逻辑删除
     */
    @Test
    public void testLogicDelete() {

        Integer result = userMapper.deleteById(1);
        System.out.println("result:" + result);

        User user = userMapper.selectById(1);
        System.out.println(user);
        user = userMapper.selectById(2);
        System.out.println(user);
    }


    /**
     * 测试自定义全局操作
     * 1.EmployeeMapper int deleteAll();
     * 2 public class MySqlInjector extends AutoSqlInjector {
     * 3.applicationContext.xml
     * <!-- 定义自定义注入器 -->
     * <bean id="mySqlInjector" class="MySqlInjector"></bean>
     * globalConfiguration:
     * <!--注入自定义全局操作 -->
     * <property name="sqlInjector" ref="mySqlInjector"></property>
     */
    @Test
    public void testMySqlInjector() {
        Integer result = employeeMapper.deleteAll();
        System.out.println("result: " + result);
    }

    /**
     * 代码生成    示例代码
     */
    @Test
    public void testGenerator() {
        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) // 是否支持AR模式
                .setAuthor("zhenglongsu@163.com") // 作者
                .setOutputDir("src\\main\\java") // 生成路径
                .setFileOverride(true)  // 文件覆盖
                .setIdType(IdType.AUTO) // 主键策略
                .setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I
                // IEmployeeService
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        //2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/mp")
                .setUsername("root")
                .setPassword("123456");

        //3. 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) //全局大写命名
                .setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setTablePrefix("tbl_")
                .setInclude("tbl_user", "tbl_employee");  // 生成的表

        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.suzl.mp.auto")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("beans")
                .setXml("mapper");

        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();

        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        //6. 执行
        ag.execute();

    }


}
