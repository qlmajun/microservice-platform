package com.warrior.central.home.stay.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.*;

import java.time.LocalDate;

/**
 * @author majun
 * @description 房间预定明细表映射封装对象
 * @date 2020/10/31
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("zmsk_room_reserve_detail")
public class RoomReserveDetailDO extends SuperEntity {
    private static final long serialVersionUID = -7490782318885442457L;

    /**
     * 预定Id
     */
    private String reserveId;

    /**
     * 房客姓名
     */
    private String name;

    /**
     * 房客性别，0：男，1：女
     */
    private Integer sex;

    /**
     * 房客人脸地址
     */
    private String faceAddress;

    /**
     * 房客手机号
     */
    private String phoneNumber;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 身份证头像
     */
    private String idAvatar;

    /**
     * 身份证地址
     */
    private String idAddress;
}
