package com.warrior.central.common.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

/**
 * 菜单封装对象
 *
 * @author majun
 * @date 2020/6/27
 */
@Data
public class SysMenu extends SuperEntity {

  private static final long serialVersionUID = 749360940290141161L;

  /**
   * 父Id
   */
  private Long parentId;

  /**
   * 名称
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
   * 菜单排序
   */
  private Integer sort;

  /**
   * 菜单类型
   */
  private Integer type;

  /**
   * 是否隐藏
   */
  private Boolean hidden;

  /**
   * 请求的类型
   */
  private String pathMethod;

  /**
   * 子菜单
   */
  private List<SysMenu> subMenus;

  /**
   * 角色id
   */
  private Long roleId;

  /**
   * 菜单Id集合
   */
  private Set<Long> menuIds;
}
