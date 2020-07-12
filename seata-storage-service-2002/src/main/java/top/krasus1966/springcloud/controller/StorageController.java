package top.krasus1966.springcloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.springcloud.domain.Storage;
import top.krasus1966.springcloud.entities.CommonResult;
import top.krasus1966.springcloud.service.StorageService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/7/11 22:26
 **/
@RestController
@Slf4j
public class StorageController {

    @Resource
    protected StorageService storageService;

    @PostMapping(value = "/storage/decrease")
    public CommonResult deCrease(Long productId,Integer count) {
        log.info("-------->开始从Storage-Service中扣减库存");
        Storage storage = storageService.getOne(new QueryWrapper<Storage>().eq("product_id", productId));
        storage.setUsed(storage.getUsed() + count);
        storage.setResidue(storage.getResidue() - count);
        storageService.updateById(storage);
        log.info("-------->从Storage-Service中扣减库存结束");
        return new CommonResult(200, "删减库存");
    }
}
