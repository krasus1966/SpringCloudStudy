package top.krasus1966.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Krasus1966
 * @date 2020/6/27 20:30
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class AppMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(AppMain8401.class,args);
    }
}
/**
 * nacos 配置  dataId:cloudalibaba-sentinel-service
 * [{
 *     "resource":"/rateLimit/byUrl", //资源名称
 *     "limitApp":"default", //来源应用
 *     "grade":1, //阈值类型 0表示线程数 1表示QPS
 *     "count":1, //单机阈值
 *     "strategy":0, //流控模式 0表示直接 1表示关联 2表示链路
 *     "controlBehavior":0, //流控效果 0表示快速失败 1表示Warm Up 2表示排队等待
 *     "clusterMode":false //是否集群
 * }]
 *
 */
