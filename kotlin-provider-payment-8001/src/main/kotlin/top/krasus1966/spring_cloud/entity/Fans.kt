package top.krasus1966.spring_cloud.entity

import lombok.Data
import java.lang.reflect.Constructor

/**
 * @author Krasus1966
 * @date 2022/5/15 10:10
 *
 **/
class Fans (
    var id: String,
    var writerId: String,
    var fanId: String,
    var face: String,
    var fanNickName: String,
    var sex: Int,
    var province: String
)
