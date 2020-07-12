package top.krasus1966.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Krasus1966
 * @date 2020/6/25 21:52
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //@LoadBalanced 注解赋予了RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
