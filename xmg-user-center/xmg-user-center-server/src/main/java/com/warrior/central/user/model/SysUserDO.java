package com.warrior.central.user.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 用户信息数据库映射封装对象
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class SysUserDO extends SuperEntity {

  private static final long serialVersionUID = 1394198291477582981L;

  /**
   * 用户名
   */
  private String username;

  /**
   * 密码
   */
  private String password;

  /**
   * 昵称
   */
  private String nickname;

  /**
   * 头像地址
   */
  private String headImgUrl;

  /**
   * 手机
   */
  private String mobile;

  /**
   * 性别
   */
  private Integer sex;

  /**
   * 可用状态
   */
  private Boolean enabled;

  /**
   * 类型
   */
  private String type;

  /**
   * 公司
   */
  private String company;

  /**
   * openId
   */
  private String openId;

  /**
   * 删除状态
   */
  @TableLogic
  private boolean isDel;

}
