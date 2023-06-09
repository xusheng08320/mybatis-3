package org.apache.ibatis.demo;

import org.apache.ibatis.binding.BindingTest;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

/**
 * @Author xusheng
 * @Date 2022/3/27 10:27 AM
 * @Desc
 */
public class MyBatisDemo {

    Log log = LogFactory.getLog(BindingTest.class);

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() {
        DataSourceFactory dataSourceFactory = new PooledDataSourceFactory();

        Properties properties = new Properties();
        properties.put("driver", "com.mysql.cj.jdbc.Driver");
        properties.put("url", "jdbc:mysql://rm-uf619362yoehgdt8s0o.mysql.rds.aliyuncs.com:3306/user_test?useSsl=false");
        properties.put("username", "xusheng");
        properties.put("password", "69123064Xs!");
        dataSourceFactory.setProperties(properties);

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSourceFactory.getDataSource());
        Configuration configuration = new Configuration(environment);
        configuration.addMappers("org.apache.ibatis.demo");
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    @Test
    public void test1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        log.debug(userDao.selectUsers().toString());
    }

    @Test
    public void test2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> user = userDao.selectByName("张三");
        System.out.println(user);
    }
}
