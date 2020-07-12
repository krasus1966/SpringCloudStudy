package top.krasus1966.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Krasus1966
 * @date 2020/6/2 16:46
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfoOk(Integer id) {
        return "PaymentFallbackService fall back paymentInfoOk";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "PaymentFallbackService fall back paymentInfoTimeout";
    }
}
