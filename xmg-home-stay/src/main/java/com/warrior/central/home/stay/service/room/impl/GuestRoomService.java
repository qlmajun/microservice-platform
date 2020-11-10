package com.warrior.central.home.stay.service.room.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.service.impl.SuperServiceImpl;
import com.warrior.central.home.constant.OccupancyConstant;
import com.warrior.central.home.stay.controller.room.dto.GuestRoomDTO;
import com.warrior.central.home.stay.mapper.room.GuestRoomMapper;
import com.warrior.central.home.stay.model.room.GuestRoomDO;
import com.warrior.central.home.stay.service.room.IGuestRoomService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author mj
 * @date 2020/11/2
 */
@Service
public class GuestRoomService extends SuperServiceImpl<GuestRoomMapper, GuestRoomDO> implements IGuestRoomService {

  @Resource
  private GuestRoomMapper guestRoomMapper;

  @Override
  public Result saveOrUpdate(GuestRoomDTO guestRoomDTO) {
    GuestRoomDO guestRoomDO = new GuestRoomDO();
    BeanUtils.copyProperties(guestRoomDTO,guestRoomDO);
    boolean result = super.saveOrUpdate(guestRoomDO);
    return result ? Result.succeed(guestRoomDO, "操作成功") : Result.failed("操作失败");
  }

  @Override
  public PageResult<GuestRoomDTO> listGuestRoom(Map<String, Object> params, String shopId) {
    Page<GuestRoomDTO> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
    List<GuestRoomDTO> guestRoomDTOS = guestRoomMapper.listGuestRoom(params,shopId);
    return PageResult.<GuestRoomDTO>builder().data(guestRoomDTOS).code(0).count(page.getTotal()).build();
  }

  @Override
  public List<GuestRoomDTO> listUnBindDeviceRoom(String shopId) {
    return guestRoomMapper.listUnBindDeviceRoom(shopId);
  }

  @Override
  public boolean checkOutRoom(String roomId) {
    GuestRoomDO guestRoomDO = new GuestRoomDO();
    guestRoomDO.setId(roomId);
    guestRoomDO.setOccupancyStatus(OccupancyConstant.CHECK_OUT_STATUS);
    return guestRoomMapper.updateById(guestRoomDO) > 0;
  }
}
