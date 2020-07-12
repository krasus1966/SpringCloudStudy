package top.krasus1966.springcloud;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Krasus1966
 * @date 2020/7/11 22:13
 **/
@MapperScan("top.krasus1966.springcloud.dao")
@SpringBootApplication
@EnableAutoDataSourceProxy
public class StorageMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(StorageMain2002.class,args);
    }
}
