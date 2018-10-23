package com.atguigu.mp.oracle.test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.csii.mp.oracle.beans.Emp;
import com.csii.mp.oracle.beans.Mer;
import com.csii.mp.oracle.beans.Merctrl;
import com.csii.mp.oracle.beans.User;
import com.csii.mp.oracle.mapper.EmpMapper;
import com.csii.mp.oracle.mapper.MerMapper;
import com.csii.mp.oracle.mapper.MerctrlMapper;
import com.csii.mp.oracle.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Date;

/**
 * @Description:
 * @author: zhenglongsu@163.com
 * @date: 2018.08.16 16:49
 */
public class TestMPOracle {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    private UserMapper userMapper =
            ctx.getBean("userMapper", UserMapper.class);
    private MerctrlMapper merctrlMapper =
            ctx.getBean("merctrlMapper", MerctrlMapper.class);
    private EmpMapper empMapper =
            ctx.getBean("empMapper", EmpMapper.class);
    private MerMapper merMapper =
            ctx.getBean("merMapper", MerMapper.class);


    /**
     * 测试Oracle 主键 Sequence
     */
    @Test
    public void testOracle1() {
        Emp emp = new Emp();
        emp.setLogicFlag(1l);
        emp.setName("OracleSEQ");
        empMapper.insert(emp);
    }

    /**
     * 测试Oracle 主键 Sequence
     */
    @Test
    public void testOracle() {
        User user = new User();
        user.setLogicFlag(1l);
        user.setName("OracleSEQ");
        userMapper.insert(user);
    }

    /**
     * 通用 插入操作
     */
    @Test
    public void testCommonInsert1() {

        Mer mer = new Mer();

        mer.setMerbegin("20181012");
        mer.setMerend("20191012");
        mer.setMerstatus(1);
        mer.setMemo1("呜呜1");
        mer.setMemo2("哈哈2");
        mer.setMemo3("嘿嘿3");
        merMapper.insert(mer);

        // System.out.println("result: " + result);
        //
        // //获取当前数据在数据库中的主键值
        // String key = mer.getMernbr();
        // System.out.println("key:" + key);
    }

    /**
     * 通用 插入操作
     */
    @Test
    public void testCommonInsert() {

        Merctrl merctrl = new Merctrl();

        merctrl.setMerbegin("20181012");
        merctrl.setMerend("20191012");
        merctrl.setMerstatus(1);
        merctrl.setMemo1("呜呜1");
        merctrl.setMemo2("哈哈2");
        merctrl.setMemo3("嘿嘿3");
        merctrl.setDatelastmaint(new Date());
        Integer result = merctrlMapper.insert(merctrl);

        System.out.println("result: " + result);

        //获取当前数据在数据库中的主键值
        Long key = merctrl.getMernbr();
        System.out.println("key:" + key);
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
        dsConfig.setDbType(DbType.ORACLE)  // 设置数据库类型
                .setDriverName("oracle.jdbc.OracleDriver")
                .setUrl("jdbc:oracle:thin:@192.168.121.138:1521:ORCL")
                .setUsername("scott")
                .setPassword("tiger");

        //3. 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) //全局大写命名
                .setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setTablePrefix("tbl_")
                .setInclude("TBL_MERCTRL");  // 生成的表

        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.csii.mp.oracle")
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


    @Test
    public void testDataSource() throws Exception {
        DataSource ds = ctx.getBean("dataSource", DataSource.class);
        System.out.println(ds);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }

}
