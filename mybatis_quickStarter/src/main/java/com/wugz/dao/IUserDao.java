package com.wugz.dao;

import com.wugz.pojo.User;

import java.util.List;

/**
 * @ClassName IUserDao
 * @Description
 * @Author wugz
 * @Date 2020/2/22 20:20
 * @Version 1.0
 */
public interface IUserDao {

    public List<User> findAll() throws Exception;

    public User findByCondition(User user) throws Exception;
}
