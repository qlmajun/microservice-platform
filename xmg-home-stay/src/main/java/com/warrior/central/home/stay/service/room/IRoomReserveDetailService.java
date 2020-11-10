package com.warrior.central.home.stay.service.room;

import com.warrior.central.common.service.ISuperService;
import com.warrior.central.home.stay.controller.room.dto.ReserveTenantDTO;
import com.warrior.central.home.stay.model.room.RoomReserveDetailDO;
import java.util.List;

/**
 * @author mj
 * @date 2020/11/10
 */
public interface IRoomReserveDetailService extends ISuperService<RoomReserveDetailDO> {


  /**
   * 添加房间预定房客信息
   * @param reserveTenantDTO
   * @return
   */
  boolean addReserveTenant(ReserveTenantDTO reserveTenantDTO);

  /**
   * 获取预定Id对应的房客信息
   * @param reserveId
   * @return
   */
  List<ReserveTenantDTO> listReserveTenants(String reserveId);
}
