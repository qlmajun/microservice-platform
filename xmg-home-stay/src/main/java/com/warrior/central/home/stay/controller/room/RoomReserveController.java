package com.warrior.central.home.stay.controller.room;

import com.warrior.central.common.constant.SecurityConstants;
import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.model.SysMenu;
import com.warrior.central.home.stay.controller.room.dto.ReserveTenantDTO;
import com.warrior.central.home.stay.controller.room.dto.RoomReserveDTO;
import com.warrior.central.home.stay.service.room.IRoomReserveDetailService;
import com.warrior.central.home.stay.service.room.IRoomReserveService;
import java.util.ArrayList;
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
 * 房间预定操作Controller
 * @author mj
 * @date 2020/11/10
 */
@RestController
public class RoomReserveController {

  @Autowired
  private IRoomReserveService roomReserveService;

  @Autowired
  private IRoomReserveDetailService roomReserveDetailService;

  /**
   * 房间预定
   * @param roomReserveDTO
   * @param request
   * @return
   */
  @PostMapping("reserve/room")
  public Result reserveRoom(@RequestBody RoomReserveDTO roomReserveDTO, HttpServletRequest request){
    String shopId = request.getHeader(SecurityConstants.USER_SHOP_ID_HEADER);
    roomReserveDTO.setShopId(shopId);
    String id = roomReserveService.reserveRoom(roomReserveDTO);
    return Result.succeed(id,"预定成功");
  }

  /**
   * 获取门店已预定的房间列表
   * @param params
   * @param request
   * @return
   */
  @GetMapping("reserved/rooms")
  public PageResult<RoomReserveDTO> listReservedRoom(@RequestParam Map<String, Object> params,HttpServletRequest request){
    String shopId = request.getHeader(SecurityConstants.USER_SHOP_ID_HEADER);
    return roomReserveService.listReservedRoom(shopId,params);
  }

  /**
   * 添加房间预定房客信息
   * @param reserveTenantDTO
   * @return
   */
  @PostMapping("reserve/tenants")
  public Result addReserveTenant(@RequestBody ReserveTenantDTO reserveTenantDTO){
    boolean success = roomReserveDetailService.addReserveTenant(reserveTenantDTO);
    if(!success){
      return Result.failed("操作失败");
    }
    return Result.succeed("操作成功");
  }

  /**
   * 获取预定Id对应的房客信息
   * @param reserveId
   * @return
   */
  @GetMapping("reserve/tenants")
  public PageResult<ReserveTenantDTO> listReserveTenants(@RequestParam String reserveId){
    List<ReserveTenantDTO> reserveTenantDTOS = roomReserveDetailService.listReserveTenants(reserveId);
    long total = reserveTenantDTOS.size();
    return PageResult.<ReserveTenantDTO>builder().data(reserveTenantDTOS).code(0).count(total).build();
  }

  /**
   * 退房
   * @param reserveId 订单Id
   * @return
   */
  @PostMapping("check/out/room")
  public Result checkOutRoom(@RequestParam String reserveId){
    boolean success = roomReserveService.checkOutRoom(reserveId);
    if(!success){
      return Result.failed("操作失败");
    }
    return Result.succeed("操作成功");
  }

  /**
   * 根据订单Id获取预定房间信息
   * @param reserveId 订单Id
   * @return
   */
  @GetMapping("ordered/room")
  public PageResult<RoomReserveDTO> getReserveRoom(@RequestParam String reserveId){
    RoomReserveDTO roomReserveDTO = roomReserveService.getReserveRoom(reserveId);
    List<RoomReserveDTO> list = new ArrayList<>(1);
    list.add(roomReserveDTO);
    return PageResult.<RoomReserveDTO>builder().data(list).code(0).count(1L).build();
  }
}
