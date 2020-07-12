package top.krasus1966.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.krasus1966.springcloud.entities.CommonResult;
import top.krasus1966.springcloud.entities.Payment;
import top.krasus1966.springcloud.handler.ConsumerHandler;
import top.krasus1966.springcloud.service.PaymentFallbackService;
import top.krasus1966.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/7/7 22:28
 **/
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback",fallback = "handlerFallback")
    //同时配置blockHandler和fallback时，报错先进入fallback方法，超过数量后进入blockHandler方法
    //降级规则的时间窗口为在此时间内出现多少异常（或其他），熔断时间为1分钟
    //exceptionsToIgnore 会忽视此规则内出现的异常，不会被降级规则管理
    @SentinelResource(value = "fallback",
            blockHandlerClass = ConsumerHandler.class,
            blockHandler = "consumerHandlerException",
            fallback = "handlerFallback",
            exceptionsToIgnore = {IllegalArgumentException.class}
    )
    //注意：兜底方法的参数要与主方法的参数一致，不然会导致无法找到方法，抛出UndeclaredThrowableException错误
    public CommonResult<Payment> fallback(@PathVariable Long id){
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL+"/paymentSQL/"+id,CommonResult.class,id);
        if (id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        }else if(result.getData() == null){
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }

    public CommonResult handlerFallback(@PathVariable Long id,Throwable e){
        Payment payment = new Payment(id,"null");
        return new CommonResult(5000,"fallback 程序出现异常:"+e.getMessage(),payment);
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    @SentinelResource(value = "feignPaymentSQL",
            blockHandlerClass = ConsumerHandler.class,
            blockHandler = "consumerHandlerException",
            fallbackClass = PaymentFallbackService.class,
            fallback = "fallback"
    )
    public CommonResult<Payment> paymentSQL(@PathVariable("id")Long id){
        return paymentService.paymentSQL(id);
    }
}
