package com.hyl.hyl.mapper;

import com.hyl.hyl.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //获取所有用户的数据
    @Select("SELECT * FROM user where id = #{id}")
    User findAll(Integer id);

    //删除用户数据
    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer id);

    //增加用户信息
    @Insert("insert into user(loginName,password,email,code,studentId) values (#{loginName},#{password},#{email},#{code},#{studentId})")
    void addUser(User user);

    //修改用户密码
    @Update("update user set  password = #{password}  where id = #{id}")
    void updateUser(User user);

    //登录验证
    @Select("SELECT * FROM user WHERE loginName = #{loginName} AND password = #{password}")
    User login(User user);

    //修改用户信息
    @Update("update user set code= #{code}, userName = #{userName}, loginName = #{loginName},email = #{email},studentId = #{studentId} where id = #{id}")
    void updateInfo(User user);

    //通过loginName查找用户id
    @Select("SELECT id FROM user WHERE loginName = #{loginName}")
    User getUserInfoByloginName(String loginName);
}
