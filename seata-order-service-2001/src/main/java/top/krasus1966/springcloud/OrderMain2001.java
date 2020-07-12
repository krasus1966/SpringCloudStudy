package top.krasus1966.springcloud;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Krasus1966
 * @date 2020/7/9 20:59
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableAutoDataSourceProxy
public class OrderMain2001 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain2001.class,args);
    }
}
