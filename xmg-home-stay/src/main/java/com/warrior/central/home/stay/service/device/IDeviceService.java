package com.warrior.central.home.stay.service.device;

import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.service.ISuperService;
import com.warrior.central.home.stay.controller.device.dto.DeviceDTO;
import com.warrior.central.home.stay.model.DeviceDO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * 设备操作服务接口声明
 */
public interface IDeviceService extends ISuperService<DeviceDO> {

    /**
     * 新增or更新设备
     * @param deviceDTO 设备封装对象
     * @return
     */
    Result saveOrUpdate(@RequestBody DeviceDTO deviceDTO);

    /**
     * 已售设备查询列表
     * @param params
     * @return
     */
    PageResult<DeviceDTO> listSoldDevice(Map<String, Object> params);

    /**
     * 未售设备查询列表
     * @param params
     * @return
     */
    PageResult<DeviceDTO> listUnsoldDevice(Map<String, Object> params);

    /**
     * 删除设备
     * @param deviceId 设备Id
     * @return
     */
    boolean removeDevice(String deviceId);
}
