package com.warrior.central.user.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.warrior.central.common.model.SuperEntity;
import lombok.*;

/**
 * 角色菜单数据库映射封装对象
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_menu")
public class SysRoleMenuDO extends SuperEntity {

  private static final long serialVersionUID = -4687545004138548686L;

  /**
   * 角色Id
   */
  private String roleId;

  /**
   * 菜单Id
   */
  private String menuId;
}
