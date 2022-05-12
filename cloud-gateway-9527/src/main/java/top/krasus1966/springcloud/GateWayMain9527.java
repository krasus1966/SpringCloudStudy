package top.krasus1966.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Krasus1966
 * @date 2020/6/15 23:26
 **/

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class GateWayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class,args);
    }
}
