package com.wugz.mapper;

import com.wugz.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserMapper {

    List<User> findAll();


    //查询所有用户、同时查询每个用户关联的订单信息
    @Select("select * from user")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "orderList",column = "id",javaType = List.class,
                    many=@Many(select = "com.wugz.mapper.IOrderMapper.findOrderByUid"))
    })
    public List<User> findAll1();

    //添加用户
    @Insert("insert into user (id,username) values(#{id},#{username})")
    public void addUser(User user);

    //更新用户
    @Update("update user set username = #{username} where id = #{id}")
    public void updateUser(User user);

    //查询用户
    @Select("select * from user")
    public List<User> selectUser();

    //删除用户
    @Delete("delete from user where id = #{id}")
    public void deleteUser(Integer id);


    //根据id查询用户
    @Options(useCache = true)
    @Select({"select * from user where id = #{id}"})
    public User findUserById(Integer id);

}
