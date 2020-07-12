package top.krasus1966.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.krasus1966.springcloud.entities.CommonResult;

/**
 * @author Krasus1966
 * @date 2020/7/9 21:45
 **/
@FeignClient(value = "seata-account-service")
public interface AccountService {


    @PostMapping(value = "/account/decrease")
    CommonResult deCrease(@RequestParam("userId")Long userId,
                          @RequestParam("money") Double money);
}
