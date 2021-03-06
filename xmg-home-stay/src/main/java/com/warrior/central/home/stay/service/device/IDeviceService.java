package com.warrior.central.home.stay.service.device;

import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.service.ISuperService;
import com.warrior.central.home.stay.controller.device.dto.DeviceDTO;
import com.warrior.central.home.stay.model.device.DeviceDO;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;

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

    /**
     * 获取门店没有绑定客房的设备列表
     * @param shopId 门店Id
     * @return
     */
    List<DeviceDTO>  listUnBindRoomDevices(String shopId);

    /**
     * 根据设备编号获取设备信息
     * @param deviceNumber 设备编号
     * @return
     */
    DeviceDO getDeviceByNumber(String deviceNumber);

    /**
     * 获取门店设备列表
     * @param params 分页信息
     * @param shopId 门店Id
     * @return
     */
    PageResult<DeviceDTO> listShopDevices(Map<String, Object> params,String shopId);
}
