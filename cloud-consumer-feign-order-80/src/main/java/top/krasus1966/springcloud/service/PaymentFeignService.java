package top.krasus1966.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.krasus1966.springcloud.entities.CommonResult;
import top.krasus1966.springcloud.entities.Payment;

/**
 * @author Krasus1966
 * @date 2020/5/27 17:06
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE-EUREKA")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
     CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}
