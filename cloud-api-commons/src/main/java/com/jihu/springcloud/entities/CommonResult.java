package com.jihu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    //404 not_fount
    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    public CommonResult(ResultCode resultCode){
        this.success = resultCode.getSuccess();
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public CommonResult(ResultCode resultCode,String message){
        this.success = resultCode.getSuccess();
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage()+message;
    }

    public CommonResult(ResultCode resultCode,T data){
        this.success = resultCode.getSuccess();
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public CommonResult(ResultCode resultCode,T data,String message){
        this.success = resultCode.getSuccess();
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage()+message;
        this.data = data;
    }

}
