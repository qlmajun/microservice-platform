package com.warrior.central.home.stay.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.model.DeviceDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 设备表数据库操作接口声明
 */
@Mapper
public interface DeviceMapper extends SuperMapper<DeviceDO> {

    /**
     * 查询已售设备列表
     * @param page
     * @param params
     * @return
     */
    List<DeviceDO> listSoldDevice(Page<DeviceDO> page,@Param("u") Map<String, Object> params);

    /**
     * 查询未售设备列表
     * @param page
     * @param params
     * @return
     */
    List<DeviceDO> listUnsoldDevice(Page<DeviceDO> page,@Param("u") Map<String, Object> params);
}
