package com.warrior.central.home.stay.service.room.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.service.impl.SuperServiceImpl;
import com.warrior.central.home.stay.constant.OccupancyConstant;
import com.warrior.central.home.stay.controller.room.dto.RoomReserveDTO;
import com.warrior.central.home.stay.mapper.room.GuestRoomMapper;
import com.warrior.central.home.stay.mapper.room.RoomReserveMapper;
import com.warrior.central.home.stay.model.room.GuestRoomDO;
import com.warrior.central.home.stay.model.room.RoomReserveDO;
import com.warrior.central.home.stay.service.room.IGuestRoomService;
import com.warrior.central.home.stay.service.room.IRoomReserveService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 房间预定操作服务接口实现
 * @author mj
 * @date 2020/11/10
 */
@Service
public class RoomReserveService extends SuperServiceImpl<RoomReserveMapper, RoomReserveDO> implements IRoomReserveService {

  @Resource
  private RoomReserveMapper roomReserveMapper;

  @Resource
  private GuestRoomMapper guestRoomMapper;

  @Resource
  private IGuestRoomService guestRoomService;

  @Override
  @Transactional
  public String reserveRoom(RoomReserveDTO roomReserveDTO) {
    RoomReserveDO roomReserveDO = new RoomReserveDO();
    BeanUtils.copyProperties(roomReserveDTO,roomReserveDO);
    super.save(roomReserveDO);

    //修改客房入住状态
    GuestRoomDO guestRoomDO = new GuestRoomDO();
    guestRoomDO.setId(roomReserveDTO.getRoomId());
    guestRoomDO.setOccupancyStatus(OccupancyConstant.CHECK_IN_STATUS);
    guestRoomMapper.updateById(guestRoomDO);
    return roomReserveDO.getId();
  }

  @Override
  public PageResult<RoomReserveDTO> listReservedRoom(String shopId, Map<String, Object> params) {
    Page<RoomReserveDTO> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
    List<RoomReserveDTO> roomReserveDTOS = roomReserveMapper.listReservedRoom(shopId,params);
    return PageResult.<RoomReserveDTO>builder().data(roomReserveDTOS).code(0).count(page.getTotal()).build();
  }

  @Override
  @Transactional
  public boolean checkOutRoom(String reserveId) {
    RoomReserveDO roomReserveDO = roomReserveMapper.selectById(reserveId);
    roomReserveDO.setStatus(0);
    roomReserveMapper.updateById(roomReserveDO);
    return guestRoomService.checkOutRoom(roomReserveDO.getRoomId());
  }
}
