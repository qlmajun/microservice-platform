package com.warrior.central.home.stay.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author majun
 * @description 门店设备订购表映射封装对象
 * @date 2020/10/31
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("zmsk_shop_device_order")
public class ShopDeviceOrderDO extends SuperEntity {
    private static final long serialVersionUID = -1108161430653263027L;

    /**
     * 门店Id
     */
    private String shopId;

    /**
     * 设备Id
     */
    private String deviceId;
}
