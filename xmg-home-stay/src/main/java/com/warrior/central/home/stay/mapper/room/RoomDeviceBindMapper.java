package com.warrior.central.home.stay.mapper.room;

import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.model.room.RoomDeviceBindDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 房间设备绑定数据库操作接口声明
 * @author mj
 * @date 2020/11/3
 */
@Mapper
public interface RoomDeviceBindMapper extends SuperMapper<RoomDeviceBindDO> {

}
