package top.krasus1966.spring_cloud.service

import org.apache.ibatis.annotations.Param
import top.krasus1966.spring_cloud.entity.Fans
import top.krasus1966.springcloud.entities.Payment

/**
 * @author Krasus1966
 * @date 2022/5/15 10:15
 *
 **/
interface FansService {
    fun create(fans: Fans): Int

    fun getFansById(@Param("id") id: String): Fans?
}