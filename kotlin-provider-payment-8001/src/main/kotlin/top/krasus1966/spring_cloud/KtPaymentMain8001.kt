package top.krasus1966.spring_cloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

/**
 * @author Krasus1966
 * @date 2022/5/15 09:50
 *
 **/
@SpringBootApplication
@EnableEurekaClient
class KtPaymentMain8001

fun main(){
    runApplication<KtPaymentMain8001>()
}