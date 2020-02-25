package com.wugz.test;

import com.wugz.IPersistence.io.Resources;
import com.wugz.IPersistence.sqlSession.DefaultSqlSessionFactory;
import com.wugz.IPersistence.sqlSession.SqlSession;
import com.wugz.IPersistence.sqlSession.SqlSessionFactoryBuilder;
import com.wugz.dao.IUserDao;
import com.wugz.pojo.User;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @ClassName HomeWorkTest
 * @Description 作业测试
 * @Author wugz
 * @Date 2020/2/25 22:28
 * @Version 1.0
 */
public class HomeWorkTest {


    private IUserDao userMapper;

    @Before
    public void befor() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        System.out.println(resourceAsSteam);
        DefaultSqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(IUserDao.class);

    }

    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUsername("insertTest");
        user.setPassword("123456");
        System.out.println("新增数目：" + userMapper.insert(user));
    }


    @Test
    public void update() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUsername("updateTest");
        System.out.println("修改数目：" + userMapper.update(user));
    }

    @Test
    public void delete() throws Exception {
        User user = new User();
        user.setId(1);
        System.out.println("删除数目：" + userMapper.delete(user));
    }

}
