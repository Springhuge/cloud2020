package com.jihu.springcloud.controller;

import com.jihu.springcloud.entities.CommonResult;
import com.jihu.springcloud.entities.Payment;
import com.jihu.springcloud.entities.ResultCode;
import com.jihu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("********插入结果:"+result);
        if(result > 0){
            log.info("********插入成功O(∩_∩)O哈哈");
            return new CommonResult(ResultCode.INSERTSUCCESS,result);
        }else{
            return new CommonResult(ResultCode.INSERTERROR);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult create(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果:"+payment);
        if(Optional.ofNullable(payment).isPresent()){
            return new CommonResult(ResultCode.FINDSUCCESS,payment);
        }else{
            return new CommonResult(ResultCode.FINDERROR);
        }
    }

}
