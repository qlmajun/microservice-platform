package com.warrior.central.user.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.warrior.central.common.model.SuperEntity;
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
public class SysRoleUserDO extends SuperEntity {

  private static final long serialVersionUID = 3984541544440409565L;

  /**
   * 用户Id
   */
  private String userId;

  /**
   * 角色Id
   */
  private String roleId;
}
