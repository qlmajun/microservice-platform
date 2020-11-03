package com.warrior.central.home.stay.mapper.room;

import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.model.room.RoomDeviceBindDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 房间设备绑定数据库操作接口声明
 * @author mj
 * @date 2020/11/3
 */
@Mapper
public interface RoomDeviceBindMapper extends SuperMapper<RoomDeviceBindDO> {

  /**
   * 删除房间设备绑定
   * @param shopId 门店Id
   * @param roomId 房间Id
   * @param deviceId 设备Id
   * @return
   */
  int deleteRoomDeviceBind(@Param("shopId") String shopId,@Param("roomId") String roomId,@Param("deviceId") String deviceId);
}
