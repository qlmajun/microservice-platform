package com.warrior.central.home.stay.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author majun
 * @description 门店订单表映射封装对象
 * @date 2020/10/31
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("zmsk_shop_order")
public class ShopOrderDO extends SuperEntity {
    private static final long serialVersionUID = -1108161430653263027L;

    /**
     * 门店Id
     */
    private String shopId;

    /**
     * 支付金额
     */
    private BigDecimal amountMoney;

    /**
     * 订单类型：1：购买，2：续费，3：短信购买
     */
    private Integer orderType;
}
