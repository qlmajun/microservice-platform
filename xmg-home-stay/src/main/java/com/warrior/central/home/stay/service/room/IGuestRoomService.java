package com.warrior.central.home.stay.service.room;

import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.service.ISuperService;
import com.warrior.central.home.stay.controller.room.dto.GuestRoomDTO;
import com.warrior.central.home.stay.model.GuestRoomDO;
import java.util.Map;

/**
 * @author mj
 * @date 2020/11/2
 */
public interface IGuestRoomService extends ISuperService<GuestRoomDO> {

  Result saveOrUpdate(GuestRoomDTO guestRoomDTO);

  PageResult<GuestRoomDTO> listGuestRoom(Map<String, Object> params,String shopId);
}
