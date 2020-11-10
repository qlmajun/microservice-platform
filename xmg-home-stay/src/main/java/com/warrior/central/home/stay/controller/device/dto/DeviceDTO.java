package com.warrior.central.home.stay.controller.device.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author majun
 * @description 设备封装传输对象
 * @date 2020/11/1
 */
@Getter
@Setter
@ToString
public class DeviceDTO implements Serializable {

    private static final long serialVersionUID = 2821238060810049594L;

    /**
     * id
     */
    private String id;

    /**
     * 设备编号
     */
    private String number;

    /**
     * ip
     */
    private String ip;

    /**
     * apk版本
     */
    private String apkVersion;

    /**
     * MAC地址
     */
    private String macId;

    /**
     * cup ID
     */
    private String cupId;

    /**
     * 上线时间
     */
    private LocalDateTime onlineTime;

    /**
     * 门店Id
     */
    private String shopId;

    /**
     * 门店名称
     */
    private String shopName;

    /**
     * 设备有效期
     */
    private LocalDate deadline;

    /**
     * 设备可用状态，
     */
    private Boolean enableStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 绑定房间Id
     */
    private String roomId;

    /**
     * 绑定房间号
     */
    private String roomNumber;
}
