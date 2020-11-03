package com.warrior.central.home.stay.service.device.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.service.impl.SuperServiceImpl;
import com.warrior.central.home.stay.controller.device.dto.DeviceDTO;
import com.warrior.central.home.stay.mapper.device.DeviceMapper;
import com.warrior.central.home.stay.model.device.DeviceDO;
import com.warrior.central.home.stay.service.device.IDeviceService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author majun
 * @description 设备操作服务接口实现
 * @date 2020/11/1
 */
@Service
public class DeviceService extends SuperServiceImpl<DeviceMapper, DeviceDO> implements IDeviceService {

    @Resource
    private DeviceMapper deviceMapper;

    @Override
    public Result saveOrUpdate(DeviceDTO deviceDTO) {
        DeviceDO deviceDO = new DeviceDO();
        BeanUtils.copyProperties(deviceDTO,deviceDO);
        boolean result = super.saveOrUpdate(deviceDO);
        return result ? Result.succeed(deviceDO, "操作成功") : Result.failed("操作失败");
    }

    @Override
    public PageResult<DeviceDTO> listSoldDevice(Map<String, Object> params) {
        Page<DeviceDO> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        //获取设备列表
        List<DeviceDTO> deviceDTOS = deviceMapper.listSoldDevice(page,params);
        return PageResult.<DeviceDTO>builder().data(deviceDTOS).code(0).count(page.getTotal()).build();
    }

    @Override
    public PageResult<DeviceDTO> listUnsoldDevice(Map<String, Object> params) {
        Page<DeviceDO> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        //获取设备列表
        List<DeviceDO> deviceDOList = deviceMapper.listUnsoldDevice(page,params);
        List<DeviceDTO> deviceDTOS = new ArrayList<>(deviceDOList.size());
        deviceDOList.stream().forEach(deviceDO -> {
            DeviceDTO deviceDTO = new DeviceDTO();
            BeanUtils.copyProperties(deviceDO,deviceDTO);
            deviceDTOS.add(deviceDTO);
        });
        return PageResult.<DeviceDTO>builder().data(deviceDTOS).code(0).count(page.getTotal()).build();
    }

    @Override
    public boolean removeDevice(String deviceId) {
        return deviceMapper.deleteById(deviceId) > 0;
    }

    @Override
    public List<DeviceDTO> listUnBindRoomDevices(String shopId) {
        return deviceMapper.listUnBindRoomDevices(shopId);
    }

    @Override
    public DeviceDO getDeviceByNumber(String deviceNumber) {
        return deviceMapper.selectOne(new QueryWrapper<DeviceDO>().eq("number",deviceNumber));
    }
}
