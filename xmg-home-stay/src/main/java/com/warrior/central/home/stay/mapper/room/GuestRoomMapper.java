package com.warrior.central.home.stay.mapper.room;

import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.controller.room.dto.GuestRoomDTO;
import com.warrior.central.home.stay.model.room.GuestRoomDO;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 房间信息表数据库操作接口声明
 */
@Mapper
public interface GuestRoomMapper extends SuperMapper<GuestRoomDO> {

  List<GuestRoomDTO> listGuestRoom(@Param("u") Map<String, Object> params, @Param("shopId") String shopId);

  /**
   *获取门店未绑定设备的客房列表
   * @param shopId 门店Id
   * @return
   */
  List<GuestRoomDTO> listUnBindDeviceRoom(@Param("shopId") String shopId);
}
