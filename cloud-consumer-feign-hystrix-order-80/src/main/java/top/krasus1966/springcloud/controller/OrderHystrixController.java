package top.krasus1966.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.springcloud.service.PaymentHystrixService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/5/29 16:59
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoOk(id);
    }

    //ribbon 默认超时时间为1秒，如果超过一秒则直接进入兜底方法
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
//    })
    @HystrixCommand
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoTimeout(id);
    }

    public String paymentInfoTimeoutFallbackMethod(@PathVariable("id")Integer id){
        return "消费者80，对方系统繁忙，请稍后再试。";
    }

    // 全局Fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global，请稍后再试";
    }
}
