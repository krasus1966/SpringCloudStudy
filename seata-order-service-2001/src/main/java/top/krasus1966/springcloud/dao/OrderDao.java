package top.krasus1966.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.krasus1966.springcloud.domain.Order;


/**
 * @author Krasus1966
 * @date 2020/7/9 21:39
 **/
@Mapper
public interface OrderDao extends BaseMapper<Order> {

}
