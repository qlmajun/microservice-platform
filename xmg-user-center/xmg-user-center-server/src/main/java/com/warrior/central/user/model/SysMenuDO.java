package com.warrior.central.user.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 菜单数据库映射封装对象
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_menu")
public class SysMenuDO extends SuperEntity {

  private static final long serialVersionUID = -8700827725620225805L;

  /**
   * 父Id
   */
  private String parentId;

  /**
   * 菜单名
   */
  private String name;

  /**
   * css样式
   */
  private String css;

  /**
   * 菜单url
   */
  private String url;

  /**
   * 菜单path
   */
  private String path;

  /**
   * 排序
   */
  private Integer sort;

  /**
   * 类型 目录、菜单、资源
   */
  private Integer type;

  /**
   * 隐藏状态
   */
  private Boolean hidden;

  /**
   * 请求的类型
   */
  private String pathMethod;

}
