package com.warrior.central.home.stay.service.room;

import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.service.ISuperService;
import com.warrior.central.home.stay.controller.room.dto.GuestRoomDTO;
import com.warrior.central.home.stay.model.room.GuestRoomDO;
import java.util.List;
import java.util.Map;

/**
 * @author mj
 * @date 2020/11/2
 */
public interface IGuestRoomService extends ISuperService<GuestRoomDO> {

  /**
   * 新增OR修改门店房间
   * @param guestRoomDTO
   * @return
   */
  Result saveOrUpdate(GuestRoomDTO guestRoomDTO);

  /**
   * 获取门店房间列表
   * @param params
   * @param shopId
   * @return
   */
  PageResult<GuestRoomDTO> listGuestRoom(Map<String, Object> params,String shopId);

  /**
   *获取门店未绑定设备的客房列表
   * @param shopId 门店Id
   * @return
   */
  List<GuestRoomDTO> listUnBindDeviceRoom(String shopId);
}
