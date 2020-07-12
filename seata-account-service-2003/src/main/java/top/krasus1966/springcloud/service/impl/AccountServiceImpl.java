package top.krasus1966.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.krasus1966.springcloud.dao.AccountDao;
import top.krasus1966.springcloud.domain.Account;
import top.krasus1966.springcloud.service.AccountService;

/**
 * @author Krasus1966
 * @date 2020/7/12 11:20
 **/
@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {
}
