package com.warrior.central.home.stay.controller.room;

import com.warrior.central.common.constant.SecurityConstants;
import com.warrior.central.common.model.Result;
import com.warrior.central.home.stay.controller.room.dto.RoomDeviceBindDTO;
import com.warrior.central.home.stay.service.room.IRoomDeviceService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 房间设备操作Controller
 * @author mj
 * @date 2020/11/3
 */
@RestController
public class RoomDeviceController {

  @Autowired
  private IRoomDeviceService roomDeviceService;

  /**
   * 绑定房间设备
   * @param roomDeviceBindDTO
   * @return
   */
  @PostMapping("room/device/bind")
  public Result roomDeviceBind(@RequestBody RoomDeviceBindDTO roomDeviceBindDTO, HttpServletRequest request){
    String shopId = request.getHeader(SecurityConstants.USER_SHOP_ID_HEADER);
    String roomId = roomDeviceBindDTO.getId();
    String deviceId = roomDeviceBindDTO.getDeviceId();
    boolean success = roomDeviceService.roomDeviceBind(shopId,roomId,deviceId);
    if(!success){
      return Result.failed("绑定失败");
    }
    return Result.succeed("绑定成功");
  }

  /**
   * 解绑房间设备
   * @param roomId 房间Id
   * @param deviceNumber 设备编号
   * @param request
   * @return
   */
  @PostMapping("room/device/unbind")
  public Result roomDeviceUnbind(String roomId,String deviceNumber,HttpServletRequest request){
    String shopId = request.getHeader(SecurityConstants.USER_SHOP_ID_HEADER);
    boolean success = roomDeviceService.roomDeviceUnbind(shopId,roomId,deviceNumber);
    if(!success){
      return Result.failed("解绑失败");
    }
    return Result.succeed("解绑成功");
  }

}
