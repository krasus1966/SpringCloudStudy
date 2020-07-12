package top.krasus1966.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.krasus1966.springcloud.entities.CommonResult;
import top.krasus1966.springcloud.entities.Payment;

/**
 * @author Krasus1966
 * @date 2020/7/8 9:52
 **/
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
