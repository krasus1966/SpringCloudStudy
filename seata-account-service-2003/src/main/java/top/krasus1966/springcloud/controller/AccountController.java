package top.krasus1966.springcloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.springcloud.domain.Account;
import top.krasus1966.springcloud.entities.CommonResult;
import top.krasus1966.springcloud.service.AccountService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/7/12 11:21
 **/
@RestController
@Slf4j
public class AccountController {

    @Resource
    protected AccountService accountService;


    @PostMapping(value = "/account/decrease")
    CommonResult deCrease(Long userId, Double money){
        log.info("-------->AccountService执行，扣减账户余额");
        Account account = accountService.getOne(new QueryWrapper<Account>().eq("user_id",userId));
        account.setUsed(account.getUsed()+money);
        account.setResidue(account.getResidue()-money);
        accountService.updateById(account);
        log.info("-------->AccountService执行完成，扣减账户余额");
        return new CommonResult(200,"账户额度扣减成功");
    }
}
