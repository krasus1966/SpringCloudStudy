package top.krasus1966.spring_cloud.controller

import org.springframework.web.bind.annotation.*
import top.krasus1966.spring_cloud.entity.Fans
import top.krasus1966.spring_cloud.service.FansService
import top.krasus1966.springcloud.entities.CommonResult
import javax.annotation.Resource

/**
 * @author Krasus1966
 * @date 2022/5/15 10:22
 *
 **/
@RestController
class FansController {
    @Resource
    private val fansService: FansService? = null

    @PostMapping("/fans/create")
    fun create(@RequestBody fans: Fans): CommonResult<*>? {
        val result: Int = fansService?.create(fans)?:0
        return if (result > 0) {
            CommonResult<Any?>(200, "插入数据库成功,serverPort:", result)
        } else {
            CommonResult<Any?>(444, "插入数据库失败,serverPort:")
        }
    }

    @GetMapping("/fans/get/{id}")
    fun getFansById(@PathVariable("id") id: String): CommonResult<*>? {
        val fans: Fans? = fansService?.getFansById(id)
        return if (fans != null) {
            CommonResult<Any?>(200, "serverPort:" + "查询成功", fans)
        } else {
            CommonResult<Any?>(444, "serverPort:" + "无记录，查询ID：" + id)
        }
    }
}