package com.warrior.central.home.stay.mapper.room;

import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.model.RoomReserveDetailDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 房间预定明细表数据库操作接口声明
 */
@Mapper
public interface RoomReserveDetailMapper extends SuperMapper<RoomReserveDetailDO> {
}
