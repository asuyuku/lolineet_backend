package com.lolineet.standard.base;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static Result ok(){
        return new Result(200,"操作成功",null   );
    }

    public static Result ok(String message,Object data){
        return new Result(200,message,data);
    }

    public static Result ok(String message){
        return new Result(200,message,null   );
    }

    public static Result ok(Object data){
        return new Result(200,"操作成功",data);
    }

    public static Result error(){
        return new Result(500,"操作失败",null);
    }
}
