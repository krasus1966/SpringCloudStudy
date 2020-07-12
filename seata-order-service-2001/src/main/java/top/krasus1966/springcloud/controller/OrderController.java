package top.krasus1966.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.springcloud.domain.Order;
import top.krasus1966.springcloud.entities.CommonResult;
import top.krasus1966.springcloud.service.OrderService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/7/9 21:43
 **/
@RestController
public class OrderController {

    @Resource
    protected OrderService orderService;

    @GetMapping(value = "/order/create",produces = "application/json")
    public CommonResult create(Order order){
        orderService.save(order);
        return new CommonResult(200,"订单创建成功",null);
    }
}
