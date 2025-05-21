package com.hyl.hyl.service;


import com.hyl.hyl.pojo.User;

import java.util.List;

public interface UserService {
    //查询所有用户信息
    User findAll(Integer id);

    //删除用户信息
    void deleteUser(Integer id);

    //增加用户信息(注册用户)
    void addUser(User user);

    //修改用户密码
    void updateUser(User user);

    //登录校验
    User login(User user);

    void updateInfo(User user);

    //通过token获取用户信息
    User getUserInfoByToken(String loginName,String token);

    //上传头像
    void updataImage(User user);
}
