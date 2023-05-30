package com.likejin.bootplus.pojo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Likejin
 * @since 2023-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "order_id", type = IdType.AUTO)
    private String orderId;

    private LocalDateTime createTime;

    private BigDecimal price;

    private Integer status;

    private Integer userId;


}
