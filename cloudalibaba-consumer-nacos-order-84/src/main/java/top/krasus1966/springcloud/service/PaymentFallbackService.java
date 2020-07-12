package top.krasus1966.springcloud.service;

import org.springframework.stereotype.Component;
import top.krasus1966.springcloud.entities.CommonResult;
import top.krasus1966.springcloud.entities.Payment;

/**
 * @author Krasus1966
 * @date 2020/7/8 9:54
 **/
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"Feign 服务降级返回");
    }

    public CommonResult<Payment> fallback(Long id){
        return new CommonResult<>(55555,"Sentinel 服务降级");
    }
}
