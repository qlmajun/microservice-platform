package com.warrior.central.home.stay.controller.room.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author mj
 * @date 2020/11/2
 */
@Getter
@Setter
@ToString
public class GuestRoomDTO implements Serializable {

  private static final long serialVersionUID = -7359688144859871942L;

  /**
   * id
   */
  private String id;

  /**
   * 房号
   */
  private String roomNumber;

  /**
   * 价格
   */
  private Integer roomPrice;

  /**
   * 房间类型Id
   */
  private String roomTypeId;

  /**
   * 房间类型名
   */
  private String roomTypeName;

  /**
   * 门店Id
   */
  private String shopId;

  /**
   * 入住状态，0：未入住，1：已入住
   */
  private Integer occupancyStatus = 0;

  /**
   * 创建时间
   */
  private Date createTime;

}
