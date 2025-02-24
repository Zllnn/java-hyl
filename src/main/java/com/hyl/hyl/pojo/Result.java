package com.hyl.hyl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//响应码，1成功，0失败
    private String message;//响应信息
    private Object data;//响应数据

    // 手动添加一个带参数的构造方法
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Result success(){//增删改成功的响应
        return new Result(1,"success",null);
    }
    public static Result success(Object data){//查询成功的响应
        return new Result(1,"success",data);
    }
    public static Result error(String message){//失败的响应
        return new Result(0,message,null);
    }
}
