package com.hyl.hyl.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.hyl.hyl.pojo.Result;
import com.hyl.hyl.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    //return true代表放行，false代表拦截（这部分在请求处理之前执行）
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //此处需要进行taken的验证，如果taken不存在或者taken过期，则拦截
        //获取请求的url
        String url = request.getRequestURL().toString();
//        log.info("请求url："+url);
        //判断是否为登录页面
        if(url.contains("/login")){
//            log.info("登录页面,放行");
            return true;
        }

        //获取querystring中的taken参数
        String taken = request.getHeader("taken");

        //判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if(!StringUtils.hasLength(taken)){
            log.info("令牌不存在，拦截");
            Result error= Result.error("未登录");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        //解析令牌，判断是否过期，如果过期，返回错误结果（登录过期）
        try{
            JwtUtils.parseJwt(taken);
        }catch (Exception e){
            e.printStackTrace();
            log.info("令牌过期，拦截");
            Result error= Result.error("登录过期");
            String expired = JSONObject.toJSONString(error);
            response.getWriter().write(expired);
            return false;
        }

        //如果令牌存在且未过期，放行
        return true;
    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
