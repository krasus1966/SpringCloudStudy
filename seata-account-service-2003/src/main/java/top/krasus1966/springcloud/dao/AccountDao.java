package top.krasus1966.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.krasus1966.springcloud.domain.Account;

/**
 * @author Krasus1966
 * @date 2020/7/12 11:18
 **/
@Mapper
public interface AccountDao extends BaseMapper<Account> {

}
