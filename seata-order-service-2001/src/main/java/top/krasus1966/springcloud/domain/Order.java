package top.krasus1966.springcloud.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Krasus1966
 * @date 2020/7/9 20:56
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_order")
public class Order {

    @TableId
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private Double money;

    /**
     * 订单状态：0，创建中，1，已完成
     */
    private Integer status;
}
