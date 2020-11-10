package com.warrior.central.home.stay.mapper.room;

import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.controller.room.dto.RoomReserveDTO;
import com.warrior.central.home.stay.model.room.RoomReserveDO;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 房间预定表数据库操作接口声明
 */
@Mapper
public interface RoomReserveMapper extends SuperMapper<RoomReserveDO> {

  /**
   * 获取已预定列表
   * @param shopId
   * @param params
   * @return
   */
  List<RoomReserveDTO> listReservedRoom(@Param("shopId") String shopId, @Param("u") Map<String, Object> params);
}
