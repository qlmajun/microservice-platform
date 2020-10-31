package com.warrior.central.home.stay.mapper;

import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.model.RoomTypeDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 房间类型数据库操作接口声明
 */
@Mapper
public interface RoomTypeMapper extends SuperMapper<RoomTypeDO> {
}
