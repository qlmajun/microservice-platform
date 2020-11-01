package com.warrior.central.home.stay.controller.device;

import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.home.stay.controller.device.dto.DeviceDTO;
import com.warrior.central.home.stay.service.device.IDeviceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author majun
 * @description 设备操作Controller
 * @date 2020/11/1
 */
@RestController
public class DeviceController {

    @Autowired
    private IDeviceService deviceService;

    /**
     * 新增or更新设备
     * @param deviceDTO 设备封装对象
     * @return
     */
    @PostMapping("/devices/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody DeviceDTO deviceDTO){
        return deviceService.saveOrUpdate(deviceDTO);
    }

    @ApiOperation(value = "已售设备查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("/sold/devices")
    public PageResult<DeviceDTO> listSoldDevice(@RequestParam Map<String, Object> params){
        return deviceService.listSoldDevice(params);
    }

    @ApiOperation(value = "未售设备查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("/unsold/devices")
    public PageResult<DeviceDTO> listUnsoldDevice(@RequestParam Map<String, Object> params){
        return deviceService.listUnsoldDevice(params);
    }

}
