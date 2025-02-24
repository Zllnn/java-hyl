package com.hyl.hyl.service.impl;

import com.hyl.hyl.mapper.UserMapper;
import com.hyl.hyl.pojo.User;
import com.hyl.hyl.service.UserService;
import com.hyl.hyl.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
//查询所有用户数据
    @Autowired
    private UserMapper userMapper;
    //查询所有用户数据
    @Override
    public User findAll(Integer id) {
        return userMapper.findAll(id);
    }

    //根据id查询用户信息
    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

    //增加用户信息（注册用户）
    @Override
    public void addUser(User user) {
        //增加一些未输入的用户信息
        user.setCode(null);
        user.setEmail("123456@123.com");
        user.setStudentId(null);
        userMapper.addUser(user);
    }

    //修改用户密码
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    //登录校验
    @Override
    public User login(User user) {
        User tempUser=userMapper.login(user);
        return tempUser;
    }

    //修改用户信息
    @Override
    public void updateInfo(User user) {
        userMapper.updateInfo(user);
    }

    //通过token获取用户信息
    @Override
    public User getUserInfoByToken(String loginName) {

//        Claims taken= JwtUtils.parseJwt(loginName);
//        User tempUser = new User();                                     //
//        tempUser.setId(Integer.parseInt(taken.get("id").toString()));
        return userMapper.getUserInfoByloginName(loginName);
    }
}
