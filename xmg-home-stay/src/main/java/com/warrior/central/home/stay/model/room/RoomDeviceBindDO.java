package com.warrior.central.home.stay.model.room;

import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 房间设备绑定表映射封装对象
 * @author mj
 * @date 2020/11/3
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("zmsk_room_device_bind")
public class RoomDeviceBindDO extends SuperEntity {

  private static final long serialVersionUID = -2187325099448368519L;

  /**
   * 门店Id
   */
  private String shopId;

  /**
   * 房间Id
   */
  private String roomId;

  /**
   * 设备Id
   */
  private String deviceId;

}
