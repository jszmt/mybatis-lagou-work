package com.wugz.mapper;

import com.wugz.pojo.Order;
import com.wugz.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName IOrderMapper
 * @Description
 * @Author wugz
 * @Date 2020/2/23 14:34
 * @Version 1.0
 */
public interface IOrderMapper {

    List<Order> findOrderAndUser();



    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "total",column = "total"),
            @Result(property = "user",column = "uid",javaType = User.class,
                    one=@One(select = "com.wugz.mapper.IUserMapper.findUserById"))
    })
    @Select("select * from orders")
    public List<Order> findOrderAndUser1();


    @Select("select * from orders where uid = #{uid}")
    public List<Order> findOrderByUid(Integer uid);

}
