package com.warrior.central.home.stay.model.shop;

import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.*;

/**
 * @author majun
 * @description 门店参数配置表映射封装对象
 * @date 2020/10/31
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("zmsk_shop_config")
public class ShopConfigDO extends SuperEntity {
    private static final long serialVersionUID = 468980026450227085L;

    /**
     * 门店Id
     */
    private String shopId;

    /**
     * 参数名
     */
    private String name;

    /**
     * 参数值
     */
    private String value;
}
