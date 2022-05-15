package top.krasus1966.spring_cloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

/**
 * @author Krasus1966
 * @date 2022/5/15 09:27
 *
 **/
@SpringBootApplication
@EnableEurekaServer
class KtEurekaMain7001

fun main(){
   runApplication<KtEurekaMain7001>()
}