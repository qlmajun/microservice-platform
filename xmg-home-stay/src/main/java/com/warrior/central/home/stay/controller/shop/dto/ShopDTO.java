package com.warrior.central.home.stay.controller.shop.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author majun
 * @description 门店封装传输对象
 * @date 2020/10/31
 */
@Getter
@Setter
@ToString
public class ShopDTO implements Serializable {
    private static final long serialVersionUID = 3999862458144700411L;

    private String id;

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
    private Integer enableStatus = 1;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
