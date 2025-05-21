package com.hyl.hyl.controller;

import com.hyl.hyl.pojo.Result;
import com.hyl.hyl.pojo.User;
import com.hyl.hyl.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j//日志
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/Users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //查询所有用户数据(用于登录)
    //查询已登录的用户信息  ✔
    @GetMapping("/getUserData/{id}")
    public Result getUserData(@PathVariable("id") Integer id) {
        User userList=userService.findAll(id);
        log.info("用户数据查询成功");
    return Result.success(userList);
    }

    //删除用户数据(注销账户)   ✔
    @DeleteMapping("/delete/{id}")
    public Result deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        log.info("数据删除成功");
        return Result.success();
    }

    //新增用户数据(用于注册)  ✔
    @PostMapping("/reg")
    public Result addUser(@RequestBody User user) {
        userService.addUser(user);
        log.info("数据新增成功");
        return Result.success();
    }

    //修改用户密码 ✔
    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody User user) {
        userService.updateUser(user);
        log.info("密码修改成功");
        return Result.success();
    }

    //修改用户信息
    @PostMapping("/updateInfo")
    public Result updateInfo(@RequestBody User user) {
        userService.updateInfo(user);
        log.info("信息修改成功");
        return Result.success();
    }

    //使用loginName获取用户信息
    @GetMapping("/getUserInfoByToken/{loginName}")
    public Result getUserInfoByToken(@PathVariable("loginName") String loginName,@RequestHeader(value = "taken", required = false) String token) {
//        log.info("开始获取用户信息");
        User user=userService.getUserInfoByToken(loginName,token);
        log.info("用户信息获取成功");
        return Result.success(user);
    }

    @PostMapping("/updataImage")
    public Result updataImage(@RequestBody User user) {
        userService.updataImage(user);
        log.info("头像修改成功");
        return Result.success();
    }
}
