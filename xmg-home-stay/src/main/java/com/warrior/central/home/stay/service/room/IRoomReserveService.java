package com.warrior.central.home.stay.service.room;

import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.service.ISuperService;
import com.warrior.central.home.stay.controller.room.dto.RoomReserveDTO;
import com.warrior.central.home.stay.model.room.RoomReserveDO;
import java.util.List;
import java.util.Map;

/**
 * 房间预定操作服务接口声明
 * @author mj
 * @date 2020/11/10
 */
public interface IRoomReserveService extends ISuperService<RoomReserveDO> {

  /**
   * 房间预定
   * @param roomReserveDTO
   * @return
   */
  String reserveRoom(RoomReserveDTO roomReserveDTO);

  /**
   * 获取门店已预定的房间列表
   * @param shopId
   * @param params
   * @return
   */
  PageResult<RoomReserveDTO> listReservedRoom(String shopId, Map<String, Object> params);

  /**
   * 退房
   * @param reserveId 订单Id
   * @return
   */
  boolean checkOutRoom(String reserveId);

  /**
   * 根据订单Id获取预定房间信息
   * @param reserveId 订单Id
   * @return
   */
  RoomReserveDTO getReserveRoom(String reserveId);
}
