package com.warrior.central.home.stay.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.*;

/**
 * @author majun
 * @description 门店手机短信记录表映射封装对象
 * @date 2020/10/31
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("zmsk_shop_sms")
public class ShopSmsDO extends SuperEntity {
    private static final long serialVersionUID = 6261684180637844341L;

    /**
     * 门店Id
     */
    private String shopId;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 发送手机号
     */
    private String phoneNumber;

    /**
     * 短信内容
     */
    private String content;
}
