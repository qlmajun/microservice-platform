package com.warrior.central.home.stay.model.room;

import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.*;

/**
 * @author majun
 * @description 客房类型表映射封装对象
 * @date 2020/10/31
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("zmsk_room_type")
public class RoomTypeDO extends SuperEntity {

    private static final long serialVersionUID = -4610985049939498692L;

    /**
     * 门店Id
     */
    private String shopId;

    /**
     * 类型名称
     */
    private String name;
}
