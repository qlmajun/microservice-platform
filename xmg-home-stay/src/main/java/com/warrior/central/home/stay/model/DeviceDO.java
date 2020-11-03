package com.warrior.central.home.stay.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author majun
 * @description 设备信息表映射封装对象
 * @date 2020/10/31
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("zmsk_device")
public class DeviceDO extends SuperEntity {
    private static final long serialVersionUID = 1001504159146620929L;

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
     * 设备有效期
     */
    private LocalDate deadline;

    /**
     * 设备可用状态，0：不可用，1：可用
     */
    private Integer enableStatus = 1;
}
