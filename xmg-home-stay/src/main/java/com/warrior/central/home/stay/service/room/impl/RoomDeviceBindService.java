package com.warrior.central.home.stay.service.room.impl;

import com.warrior.central.common.service.impl.SuperServiceImpl;
import com.warrior.central.home.stay.mapper.room.RoomDeviceBindMapper;
import com.warrior.central.home.stay.model.room.RoomDeviceBindDO;
import com.warrior.central.home.stay.service.room.IRoomDeviceBindService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 房间设备绑定操作服务接口实现
 * @author mj
 * @date 2020/11/3
 */
@Service
public class RoomDeviceBindService extends SuperServiceImpl<RoomDeviceBindMapper, RoomDeviceBindDO> implements IRoomDeviceBindService {

  @Resource
  private RoomDeviceBindMapper roomDeviceBindMapper;

  @Override
  public boolean roomDeviceBind(String shopId,String roomId, String deviceId) {
    RoomDeviceBindDO roomDeviceBindDO = new RoomDeviceBindDO();
    roomDeviceBindDO.setShopId(shopId);
    roomDeviceBindDO.setDeviceId(deviceId);
    roomDeviceBindDO.setRoomId(roomId);
    return roomDeviceBindMapper.insert(roomDeviceBindDO) > 0;
  }
}
