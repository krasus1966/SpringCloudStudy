package top.krasus1966.springcloud.service.impl;

import org.springframework.stereotype.Service;
import top.krasus1966.springcloud.dao.PaymentDao;
import top.krasus1966.springcloud.entities.Payment;
import top.krasus1966.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/5/19 16:51
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
