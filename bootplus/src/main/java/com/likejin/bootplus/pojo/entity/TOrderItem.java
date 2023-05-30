package com.likejin.bootplus.pojo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
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
public class TOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer count;

    private BigDecimal price;

    private BigDecimal totalPrice;

    private String orderId;


}
