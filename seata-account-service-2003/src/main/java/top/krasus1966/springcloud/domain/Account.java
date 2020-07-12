package top.krasus1966.springcloud.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Krasus1966
 * @date 2020/7/12 11:02
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_account")
public class Account {

    @TableId
    private Long id;

    @TableField("user_id")
    private Long userId;

    private Double total;

    private Double used;

    private Double residue;
}
