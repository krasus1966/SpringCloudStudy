package top.krasus1966.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.PathVariable;
import top.krasus1966.springcloud.entities.CommonResult;

/**
 * @author Krasus1966
 * @date 2020/7/8 8:44
 **/
public class ConsumerHandler {

    public static CommonResult consumerHandlerException(@PathVariable Long id, BlockException exception){
        return new CommonResult(550,"自定义过滤规则",exception.getMessage());
    }
}
