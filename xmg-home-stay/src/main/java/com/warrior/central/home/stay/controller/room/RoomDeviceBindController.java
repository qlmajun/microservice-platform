package com.warrior.central.home.stay.controller.room;

import com.warrior.central.common.constant.SecurityConstants;
import com.warrior.central.common.model.Result;
import com.warrior.central.home.stay.controller.room.dto.RoomDeviceBindDTO;
import com.warrior.central.home.stay.service.room.IRoomDeviceBindService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 房间设备绑定操作Controller
 * @author mj
 * @date 2020/11/3
 */
@RestController
public class RoomDeviceBindController {

  @Autowired
  private IRoomDeviceBindService roomDeviceBindService;

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
    boolean success = roomDeviceBindService.roomDeviceBind(shopId,roomId,deviceId);
    if(!success){
      return Result.failed("绑定失败");
    }
    return Result.succeed("绑定成功");
  }
}
