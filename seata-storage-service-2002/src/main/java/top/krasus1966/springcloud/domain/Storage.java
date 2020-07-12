package top.krasus1966.springcloud.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Krasus1966
 * @date 2020/7/11 22:18
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_storage")
public class Storage {

    @TableId
    private Long id;

    @TableField("product_id")
    private Integer productId;

    private Integer total;

    private Integer used;

    private Integer residue;
}
