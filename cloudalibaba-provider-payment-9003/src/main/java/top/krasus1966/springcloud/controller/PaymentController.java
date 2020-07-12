package top.krasus1966.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.springcloud.entities.CommonResult;
import top.krasus1966.springcloud.entities.Payment;

import java.util.HashMap;

/**
 * @author Krasus1966
 * @date 2020/7/7 22:16
 **/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"123"));
        hashMap.put(2L,new Payment(2L,"456"));
        hashMap.put(3L,new Payment(3L,"789"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id")Long id){
        Payment payment = hashMap.get(id);
        return new CommonResult<>(200,"from mysql,ServerPort:"+serverPort,payment);
    }
}
