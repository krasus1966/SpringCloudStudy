package top.krasus1966.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Krasus1966
 * @date 2020/7/9 22:09
 **/
@Configuration
@MapperScan("top.krasus1966.springcloud.dao")
public class MybatisConfig {
}
