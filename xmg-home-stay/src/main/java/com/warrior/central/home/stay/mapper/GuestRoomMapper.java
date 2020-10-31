package com.warrior.central.home.stay.mapper;

import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.model.GuestRoomDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 房间信息表数据库操作接口声明
 */
@Mapper
public interface GuestRoomMapper extends SuperMapper<GuestRoomDO> {
}
