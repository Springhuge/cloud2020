package com.jihu.springcloud.controller;

import com.jihu.springcloud.entities.CommonResult;
import com.jihu.springcloud.entities.Payment;
import com.jihu.springcloud.entities.ResultCode;
import com.jihu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("********插入结果:"+result);
        if(result > 0){
            log.info("********插入成功O(∩_∩)O哈哈");
            return new CommonResult(ResultCode.INSERTSUCCESS,result,",serverPort:"+serverPort);
        }else{
            return new CommonResult(ResultCode.INSERTERROR,",serverPort:"+serverPort);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult create(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果:"+payment);
        if(Optional.ofNullable(payment).isPresent()){
            return new CommonResult(ResultCode.FINDSUCCESS,payment,",serverPort:"+serverPort);
        }else{
            return new CommonResult(ResultCode.FINDERROR,",serverPort:"+serverPort);
        }
    }

    @GetMapping("/discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element:"+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

}
