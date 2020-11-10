package com.warrior.central.home.stay.controller.room.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 预定的房客信息封装传输对象
 *
 * @author mj
 * @date 2020/11/10
 */
@Getter
@Setter
@ToString
public class ReserveTenantDTO implements Serializable {

  private static final long serialVersionUID = -4969367346685355505L;

  /**
   * id
   */
  private String id;

  /**
   * 预定Id
   */
  private String reserveId;

  /**
   * 房客姓名
   */
  private String name;

  /**
   * 房客性别，0：男，1：女
   */
  private Integer sex;

  /**
   * 房客人脸地址
   */
  private String faceAddress;

  /**
   * 房客手机号
   */
  private String phoneNumber;

  /**
   * 身份证号
   */
  private String idNumber;

  /**
   * 身份证头像
   */
  private String idAvatar;

  /**
   * 身份证地址
   */
  private String idAddress;

  /**
   * 创建时间
   */
  private Date createTime;
}
