package com.warrior.central.home.stay.controller.room.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 房间预定封装传输对象
 * @author mj
 * @date 2020/11/10
 */
@Getter
@Setter
@ToString
public class RoomReserveDTO implements Serializable {

  private static final long serialVersionUID = 3262094554356512343L;

  /**
   * id
   */
  private String id;

  /**
   * 门店Id
   */
  private String shopId;

  /**
   * 房间Id
   */
  private String roomId;

  /**
   * 房号
   */
  private String roomNumber;

  /**
   * 房间类型
   */
  private String typeName;

  /**
   * 入住时间
   */
  private LocalDate checkInDate;

  /**
   * 退房时间
   */
  private LocalDate checkOutDate;

  /**
   * 0：退房，1：正常
   */
  private Integer status = 1;

  /**
   * 创建时间
   */
  private Date createTime;
}
