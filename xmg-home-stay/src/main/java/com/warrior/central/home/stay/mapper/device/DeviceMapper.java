package com.warrior.central.home.stay.mapper.device;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.controller.device.dto.DeviceDTO;
import com.warrior.central.home.stay.model.device.DeviceDO;
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
    List<DeviceDTO> listSoldDevice(Page<DeviceDO> page,@Param("u") Map<String, Object> params);

    /**
     * 查询未售设备列表
     * @param page
     * @param params
     * @return
     */
    List<DeviceDO> listUnsoldDevice(Page<DeviceDO> page,@Param("u") Map<String, Object> params);

    /**
     * 获取门店没有绑定客房的设备列表
     * @param shopId 门店Id
     * @return
     */
    List<DeviceDTO> listUnBindRoomDevices(@Param("shopId") String shopId);

    /**
     * 获取门店设备列表
     * @param shopId 门店Id
     * @return
     */
    List<DeviceDTO> listShopDevices(@Param("shopId") String shopId);
}
