package com.wugz.test;

import com.wugz.mapper.IOrderMapper;
import com.wugz.mapper.IUserMapper;
import com.wugz.pojo.Order;
import com.wugz.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @ClassName MybatisTest
 * @Description
 * @Author wugz
 * @Date 2020/2/23 14:39
 * @Version 1.0
 */
public class MybatisTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IOrderMapper mapper = sqlSession.getMapper(IOrderMapper.class);
        List<Order> orderAndUser = mapper.findOrderAndUser();
        for (Order order : orderAndUser) {
            System.out.println(order);
        }

    }


    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        List<User> orderAndUser = mapper.findAll();
        for (User user : orderAndUser) {
            System.out.println(user);
        }

    }

    private IUserMapper userMapper;
    private IOrderMapper orderMapper;

    @Before
    public void befor() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(IUserMapper.class);
        orderMapper = sqlSession.getMapper(IOrderMapper.class);
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setId(3);
        user.setUsername("测试数据");
        user.setBirthday(new Date());
        user.setPassword("123456");
        userMapper.addUser(user);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(3);
        user.setUsername("修改了测试数据");

        userMapper.updateUser(user);

    }

    @Test
    public void selectUser(){
        List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void deleteUser(){
        userMapper.deleteUser(3);
    }

    @Test
    public void oneToOne(){
        List<Order> orderAndUser = orderMapper.findOrderAndUser1();
        for (Order order : orderAndUser) {
            System.out.println(order);
        }

    }


    @Test
    public void oneToMany(){
        List<User> all = userMapper.findAll1();
        for (User user : all) {
            System.out.println(user);
        }

    }

//    @Test
//    public void ManyToMany(){
//        List<User> all = userMapper.findAllUserAndRole();
//        for (User user : all) {
//            System.out.println(user);
//        }
//
//    }


}
