package com.warrior.central.home.stay.controller.room;

import com.warrior.central.common.constant.SecurityConstants;
import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.home.stay.controller.room.dto.GuestRoomDTO;
import com.warrior.central.home.stay.service.room.IGuestRoomService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mj
 * @date 2020/11/2
 */
@RestController
public class GuestRoomController {

  @Autowired
  private IGuestRoomService guestRoomService;

  /**
   * 获取门店房间列表
   * @param params
   * @param request
   * @return
   */
  @GetMapping("/guest/rooms")
  public PageResult<GuestRoomDTO> listGuestRoom(@RequestParam Map<String, Object> params,HttpServletRequest request){
    String shopId = request.getHeader(SecurityConstants.USER_SHOP_ID_HEADER);
    return guestRoomService.listGuestRoom(params,shopId);
  }

  /**
   * 新增OR修改门店房间
   * @param guestRoomDTO
   * @return
   */
  @PostMapping("/guest/rooms/saveOrUpdate")
  public Result saveOrUpdate(@RequestBody GuestRoomDTO guestRoomDTO,HttpServletRequest request){
    String shopId = request.getHeader(SecurityConstants.USER_SHOP_ID_HEADER);
    guestRoomDTO.setShopId(shopId);
    return guestRoomService.saveOrUpdate(guestRoomDTO);
  }

  /**
   * 获取门店未绑定设备的客房列表
   * @param request
   * @return
   */
  @GetMapping("unbind/device/guest/rooms")
  public Result<List<GuestRoomDTO>> listUnBindDeviceRoom(HttpServletRequest request){
    String shopId = request.getHeader(SecurityConstants.USER_SHOP_ID_HEADER);
    List<GuestRoomDTO> guestRoomDTOS = guestRoomService.listUnBindDeviceRoom(shopId);
    return Result.succeed(guestRoomDTOS);
  }
}
