package com.wugz.test;

import com.wugz.IPersistence.io.Resources;
import com.wugz.IPersistence.sqlSession.DefaultSqlSessionFactory;
import com.wugz.IPersistence.sqlSession.SqlSession;
import com.wugz.IPersistence.sqlSession.SqlSessionFactoryBuilder;
import com.wugz.dao.IUserDao;
import com.wugz.pojo.User;
import org.junit.Test;

import java.io.InputStream;

/**
 * @ClassName MybatisTest
 * @Description
 * @Author wugz
 * @Date 2020/2/22 12:22
 * @Version 1.0
 */
public class MybatisTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        System.out.println(resourceAsSteam);
        DefaultSqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
        User user = new User();
        user.setId(1);
        user.setUsername("updateTest");

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);


        User user11 = userDao.findByCondition(user);
        System.out.println(user11);

//
//        List<User> all = userDao.findAll();
//        for (User user1 : all) {
//            System.out.println(user1);
//        }


    }
}
