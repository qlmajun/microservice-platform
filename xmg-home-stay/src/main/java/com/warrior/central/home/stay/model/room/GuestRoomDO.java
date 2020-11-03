package com.warrior.central.home.stay.model.room;

import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.*;

/**
 * @author majun
 * @description 房间信息表映射封装对象
 * @date 2020/10/31
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("zmsk_guest_room")
public class GuestRoomDO extends SuperEntity {
    private static final long serialVersionUID = 8258450555246550835L;

    /**
     * 房号
     */
    private String roomNumber;

    /**
     * 价格
     */
    private Integer roomPrice;

    /**
     * 房间类型Id
     */
    private String roomTypeId;

    /**
     * 门店Id
     */
    private String shopId;

    /**
     * 入住状态，0：未入住，1：已入住
     */
    private Integer occupancyStatus = 0;
}
