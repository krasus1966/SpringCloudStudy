package top.krasus1966.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/5/19 17:26
 **/
@RestController
@Slf4j
public class OrderZKController {
    public static final String INVOKE_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo() {
        String result =  restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }
}
