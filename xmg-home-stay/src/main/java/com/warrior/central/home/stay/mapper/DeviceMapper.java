package com.warrior.central.home.stay.mapper;

import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.model.DeviceDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 设备表数据库操作接口声明
 */
@Mapper
public interface DeviceMapper extends SuperMapper<DeviceDO> {
}
