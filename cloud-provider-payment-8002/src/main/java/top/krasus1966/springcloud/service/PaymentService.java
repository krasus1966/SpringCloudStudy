package top.krasus1966.springcloud.service;

import org.apache.ibatis.annotations.Param;
import top.krasus1966.springcloud.entities.Payment;

/**
 * @author Krasus1966
 * @date 2020/5/19 16:50
 **/

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);
}
