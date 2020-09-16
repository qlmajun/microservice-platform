package com.warrior.central.common.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色
 *
 * @author xmg
 */
@Data
public class SysRole extends SuperEntity {

  private static final long serialVersionUID = 4497149010220586111L;

  /**
   * 角色编码
   */
  private String code;

  /**
   * 角色名
   */
  private String name;

  /**
   * 用户Id
   */
  private Long userId;
}
