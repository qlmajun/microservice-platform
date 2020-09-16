package com.warrior.central.user.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * 用户角色数据库映射封装对象
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_user")
public class SysRoleUserDO extends Model<SysRoleUserDO> {

  private static final long serialVersionUID = 3984541544440409565L;

  /**
   * 用户Id
   */
  private Long userId;

  /**
   * 角色Id
   */
  private Long roleId;
}
