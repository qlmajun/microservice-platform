package com.warrior.central.home.stay.service.room;

import com.warrior.central.common.service.ISuperService;
import com.warrior.central.home.stay.model.room.RoomDeviceBindDO;

/**
 * 房间设备绑定操作服务接口声明
 * @author mj
 * @date 2020/11/3
 */
public interface IRoomDeviceBindService extends ISuperService<RoomDeviceBindDO> {

  /**
   * 房间设备绑定
   * @param shopId 门店Id
   * @param roomId 房间Id
   * @param deviceId 设备Id
   * @return
   */
  boolean roomDeviceBind(String shopId,String roomId,String deviceId);
}
