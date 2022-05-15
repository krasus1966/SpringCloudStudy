package top.krasus1966.spring_cloud.service.impl

import org.springframework.stereotype.Service
import top.krasus1966.spring_cloud.dao.FansDAO
import top.krasus1966.spring_cloud.entity.Fans
import top.krasus1966.spring_cloud.service.FansService
import javax.annotation.Resource

/**
 * @author Krasus1966
 * @date 2022/5/15 10:15
 *
 **/
@Service
class FansServiceImpl : FansService {
    @Resource
    private val fansDAO: FansDAO? = null

    override fun create(fans: Fans): Int {
        return fansDAO?.create(fans) ?: 0
    }

    override fun getFansById(id: String): Fans? {
        return fansDAO?.getFansById(id)
    }
}