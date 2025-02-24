package com.hyl.hyl.controller;

import com.hyl.hyl.pojo.Result;
import com.hyl.hyl.pojo.User;
import com.hyl.hyl.service.UserService;
import com.hyl.hyl.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.HashMap;

@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
//        log.info("login user: {}", user);
        //验证用户是否存在
        User e = userService.login(user);
        //登录成功
        if(e!=null){
//            log.info("登录成功");
            Map<String,Object> claims = new HashMap<>();
            //返回部分用户信息
            claims.put("loginName",e.getLoginName());
            claims.put("password",e.getPassword());
            claims.put("code",e.getCode());
            claims.put("id",e.getId());
            String token = JwtUtils.generateJwt(claims);
            return Result.success(token);
        }

        //登录失败
        return Result.error("用户名或密码错误");

    }
}
