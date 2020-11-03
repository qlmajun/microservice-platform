package com.warrior.central.home.stay.service.shop;

import com.warrior.central.common.service.ISuperService;
import com.warrior.central.home.stay.model.shop.ShopDeviceOrderDO;
import java.util.List;

/**
 * 门店设备订购操作服务接口声明
 * @author mj
 * @date 2020/11/3
 */
public interface IShopDeviceOrderService extends ISuperService<ShopDeviceOrderDO> {


  /**
   * 设备销售
   * @param shopId 门店Id
   * @param deviceIds 设备Ids
   * @return
   */
  boolean saleDevices(String shopId, List<String> deviceIds);
}
