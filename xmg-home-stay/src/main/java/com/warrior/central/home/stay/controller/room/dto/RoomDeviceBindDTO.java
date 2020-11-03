package com.warrior.central.home.stay.controller.room.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author mj
 * @date 2020/11/3
 */
@Getter
@Setter
@ToString
public class RoomDeviceBindDTO implements Serializable {

  private static final long serialVersionUID = -7079274717312713327L;

  /**
   * 房间Id
   */
  private String Id;

  /**
   * 设备Id
   */
  private String deviceId;

}
