package com.warrior.central.user.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 角色信息数据库映射封装对象
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class SysRoleDO extends SuperEntity {

  private static final long serialVersionUID = -4356576186289275137L;

  /**
   * 角色编码
   */
  private String code;

  /**
   * 角色名
   */
  private String name;

  /**
   * 租户Id
   */
  private String tenantId;

}
