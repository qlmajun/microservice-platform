package com.warrior.central.home.stay.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.warrior.central.common.model.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 门店用户关系表映射封装对象
 * @author mj
 * @date 2020/11/2
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("zmsk_shop_user")
public class ShopUserDO extends SuperEntity {

  private static final long serialVersionUID = 1256392966892195055L;

  /**
   * 用户Id
   */
  private String userId;

  /**
   * 门店Id
   */
  private String shopId;

}
