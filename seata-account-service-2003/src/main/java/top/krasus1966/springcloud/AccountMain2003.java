package top.krasus1966.springcloud;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Krasus1966
 * @date 2020/7/12 10:55
 **/
@SpringBootApplication
@EnableAutoDataSourceProxy
@MapperScan("top.krasus1966.springcloud.dao")
public class AccountMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(AccountMain2003.class,args);
    }
}
