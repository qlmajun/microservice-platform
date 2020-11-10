package com.warrior.central.home.stay.service.room.impl;

import com.warrior.central.common.service.impl.SuperServiceImpl;
import com.warrior.central.home.stay.controller.room.dto.ReserveTenantDTO;
import com.warrior.central.home.stay.mapper.room.RoomReserveDetailMapper;
import com.warrior.central.home.stay.model.room.RoomReserveDetailDO;
import com.warrior.central.home.stay.service.room.IRoomReserveDetailService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mj
 * @date 2020/11/10
 */
@Service
public class RoomReserveDetailService extends SuperServiceImpl<RoomReserveDetailMapper, RoomReserveDetailDO> implements IRoomReserveDetailService {

  @Resource
  private RoomReserveDetailMapper roomReserveDetailMapper;

  @Override
  public boolean addReserveTenant(ReserveTenantDTO reserveTenantDTO) {
    RoomReserveDetailDO roomReserveDetailDO = new RoomReserveDetailDO();
    BeanUtils.copyProperties(reserveTenantDTO,roomReserveDetailDO);
    return super.save(roomReserveDetailDO);
  }

  @Override
  public List<ReserveTenantDTO> listReserveTenants(String reserveId) {
    return roomReserveDetailMapper.listReserveTenants(reserveId);
  }
}
