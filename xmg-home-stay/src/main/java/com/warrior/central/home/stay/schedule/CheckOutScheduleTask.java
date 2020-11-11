package com.warrior.central.home.stay.schedule;

import com.warrior.central.home.stay.mapper.room.GuestRoomMapper;
import com.warrior.central.home.stay.mapper.room.RoomReserveMapper;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @author mj
 * @date 2020/11/11
 */
@Component
public class CheckOutScheduleTask {

  @Resource
  private RoomReserveMapper roomReserveMapper;

  @Resource
  private GuestRoomMapper guestRoomMapper;

  @Scheduled(cron="0 0 1 * * ?")
  @Transactional
  public void checkOutRoom(){
    LocalDate currentDate = LocalDate.now();
    List<String> roomIds = roomReserveMapper.listUnCheckOutRoomId(currentDate.plusDays(-1));
    if(CollectionUtils.isEmpty(roomIds)){
      return ;
    }
    roomReserveMapper.checkOutRoom(roomIds);
    guestRoomMapper.updateRoomUnoccupied(roomIds);
  }
}
