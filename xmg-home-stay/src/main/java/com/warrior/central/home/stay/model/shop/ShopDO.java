package com.warrior.central.home.stay.model.shop;

import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.*;

import java.time.LocalDate;

/**
 * @author majun
 * @description 门店表映射封装对象
 * @date 2020/10/31
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("zmsk_shop")
public class ShopDO extends SuperEntity {

    private static final long serialVersionUID = -7512291322589630504L;

    /**
     * 店家名称
     */
    private String name;

    /**
     * 店家电话
     */
    private String telNumber;

    /**
     * 店家地址
     */
    private String address;

    /**
     * 平台有效期
     */
    private LocalDate deadline;

    /**
     * '门店可用状态，0：不可用，1：可用
     */
    private Boolean enableStatus = true;
}
