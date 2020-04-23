package com.jihu.springcloud.entities;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS(true,200,"操作成功！！！"),
    //查找成功
    FINDSUCCESS(true,200,"查询成功！！！"),
    //插入数据成功
    INSERTSUCCESS(true,200,"插入数据成功！！！"),
    //更新数据成功
    UPDATESUCCESS(true,200,"更新数据成功！！！"),
    //删除数据成功
    DELTESUCCESS(true,200,"删除数据成功！！！"),

    //插入数据成功
    FINDERROR(false,444,"查询异常"),
    //查找失败
    INSERTERROR(false,444,"插入数据异常"),
    //更新数据异常
    UPDATEERROR(false,444,"更新数据异常"),
    //删除数据异常
    DELETEERROR(false,444,"删除数据异常"),

    NOTFOUND(false,404,"没用找到指定的内容！！！"),
    ERROR(false,500,"系统异常，请稍后再试！！！");

    private Boolean success;
    private Integer code;
    private String Message;

    ResultCode(Boolean success,Integer code,String message){
        this.success = success;
        this.code = code;
        this.Message = message;
    }
}
