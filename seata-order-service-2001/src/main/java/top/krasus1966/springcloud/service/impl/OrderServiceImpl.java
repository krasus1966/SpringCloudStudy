package top.krasus1966.springcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.krasus1966.springcloud.dao.OrderDao;
import top.krasus1966.springcloud.domain.Order;
import top.krasus1966.springcloud.service.AccountService;
import top.krasus1966.springcloud.service.OrderService;
import top.krasus1966.springcloud.service.StorageService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/7/9 21:41
 **/
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

    @Resource
    protected OrderDao orderDao;

    @Resource
    protected StorageService storageService;

    @Resource
    protected AccountService accountService;

    @Override
    @GlobalTransactional(name = "shop-create-order",rollbackFor = Exception.class)
    public boolean save(Order order) {
        log.info("-------->开始创建订单");
        orderDao.insert(order);
        log.info("-------->订单创建结束");

        log.info("-------->调用库存微服务，库存扣减");
        storageService.deCrease(order.getProductId(),order.getCount());
        log.info("-------->库存微服务扣减结束");

        log.info("-------->调用账户微服务，金额扣减");
        accountService.deCrease(order.getUserId(),order.getMoney());
        log.info("-------->账户微服务扣减结束");

        log.info("-------->修改订单状态开始");
        order = orderDao.selectOne(new QueryWrapper<>(order));
        order.setStatus(1);
        orderDao.updateById(order);
        log.info("-------->修改订单状态结束");


        return true;
    }
}
