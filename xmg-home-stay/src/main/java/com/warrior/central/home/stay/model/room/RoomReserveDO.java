package com.warrior.central.home.stay.model.room;

import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.*;

import java.time.LocalDate;

/**
 * @author majun
 * @description 房间预定表映射封装对象
 * @date 2020/10/31
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("zmsk_room_reserve")
public class RoomReserveDO extends SuperEntity {
    private static final long serialVersionUID = -7490782318885442457L;

    /**
     * 门店Id
     */
    private String shopId;

    /**
     * 房间Id
     */
    private String roomId;

    /**
     * 入住时间
     */
    private LocalDate checkInDate;

    /**
     * 退房时间
     */
    private LocalDate checkOutDate;

    /**
     * 0：退房，1：正常
     */
    private Integer status = 1;
}
