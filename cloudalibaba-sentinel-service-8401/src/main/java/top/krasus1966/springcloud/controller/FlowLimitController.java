package top.krasus1966.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Krasus1966
 * @date 2020/6/27 20:32
 **/
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "TESTA";
    }


    @GetMapping("/testB")
    //@SentinelResource(value = "testB",blockHandler = "handlerException")
    public String testB() {
        log.info("测试");
        return "TESTB";
    }

    @GetMapping("/testHotKey")
    // 设置兜底方法，违背热点规则后，进入兜底方法
    // 如果设置了热点规则没有设置兜底方法，会进入到错误页面500
    // 只要设置了热点规则，无论设置了哪个参数的热点规则，都会报错
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2
    ) {
        return "-------testHotKey";
    }

    // 兜底方法
    public String deal_testHotKey(String p1, String p2 , BlockException exception){
        return "deal-------testHotKey";//sentinel系统默认提示为：Blocked by Sentinel (flow limiting)
    }
    /**
     * sentinel 系统规则
     * LOAD：仅对Linux/Unix-like机器生效，
     *  系统的load1作为启发指标，进行自适应系统保护，当系统load1超过设定的启发值，
     *  且系统当前的并发线程数超过估算的系统容量时才会触发系统保护（BBR阶段）。
     *  系统容量由系统的maxQps * minRt估算得出。
     *  设定参考值一般是 CPU cores * 2.5.
     * 平均RT：平均处理时间，单位是毫秒
     * 线程数
     * 入口QPS
     * CPU使用率：取值范围 0.0-1.0
     */
}


