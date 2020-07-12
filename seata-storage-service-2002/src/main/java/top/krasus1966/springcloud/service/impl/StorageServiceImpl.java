package top.krasus1966.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.krasus1966.springcloud.dao.StorageDao;
import top.krasus1966.springcloud.domain.Storage;
import top.krasus1966.springcloud.service.StorageService;

/**
 * @author Krasus1966
 * @date 2020/7/11 22:21
 **/
@Service
public class StorageServiceImpl extends ServiceImpl<StorageDao,Storage> implements StorageService {
}
