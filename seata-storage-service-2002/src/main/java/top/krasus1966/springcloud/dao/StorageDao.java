package top.krasus1966.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.krasus1966.springcloud.domain.Storage;

/**
 * @author Krasus1966
 * @date 2020/7/11 22:20
 **/
@Mapper
public interface StorageDao extends BaseMapper<Storage> {
}
