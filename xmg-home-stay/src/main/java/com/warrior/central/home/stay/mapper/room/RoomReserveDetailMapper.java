package com.warrior.central.home.stay.mapper.room;

import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.controller.room.dto.ReserveTenantDTO;
import com.warrior.central.home.stay.model.room.RoomReserveDetailDO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 房间预定明细表数据库操作接口声明
 */
@Mapper
public interface RoomReserveDetailMapper extends SuperMapper<RoomReserveDetailDO> {

  /**
   * 获取预定Id对应的房客信息
   * @param reserveId
   * @return
   */
  List<ReserveTenantDTO> listReserveTenants(@Param("reserveId") String reserveId);
}
