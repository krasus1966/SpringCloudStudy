package top.krasus1966.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import top.krasus1966.springcloud.entities.CommonResult;

/**
 * @author Krasus1966
 * @date 2020/7/7 21:57
 **/
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444,"按客户自定义，Global handlerException----1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444,"按客户自定义，Global handlerException----2");
    }
}
