package top.krasus1966.spring_cloud.dao

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import top.krasus1966.spring_cloud.entity.Fans
import top.krasus1966.springcloud.entities.Payment

/**
 * @author Krasus1966
 * @date 2022/5/15 10:13
 *
 **/
@Mapper
interface FansDAO {
    fun create(fans: Fans): Int

    fun getFansById(@Param("id") id: String?): Fans?
}