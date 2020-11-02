package com.warrior.central.home.stay.mapper.device;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.controller.device.dto.DeviceDTO;
import com.warrior.central.home.stay.model.DeviceDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

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
     * 设备销售
     * @param shopId 门店Id
     * @param deviceIds 设备Ids
     * @return
     */
    int saleDevices(@Param("shopId") String shopId, @Param("deviceIds") List<String> deviceIds);
}
