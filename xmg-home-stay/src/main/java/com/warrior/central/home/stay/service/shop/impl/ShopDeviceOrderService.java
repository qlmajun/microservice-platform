package com.warrior.central.home.stay.service.shop.impl;

import com.warrior.central.common.service.impl.SuperServiceImpl;
import com.warrior.central.home.stay.mapper.shop.ShopDeviceOrderMapper;
import com.warrior.central.home.stay.model.ShopDeviceOrderDO;
import com.warrior.central.home.stay.service.shop.IShopDeviceOrderService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 门店设备订购操作服务接口实现
 * @author mj
 * @date 2020/11/3
 */
@Service
public class ShopDeviceOrderService extends SuperServiceImpl<ShopDeviceOrderMapper, ShopDeviceOrderDO> implements IShopDeviceOrderService {

  @Resource
  private ShopDeviceOrderMapper shopDeviceOrderMapper;

  @Override
  @Transactional
  public boolean saleDevices(String shopId, List<String> deviceIds) {
    List<ShopDeviceOrderDO> shopDeviceOrderDOS = new ArrayList<>(deviceIds.size());
    deviceIds.stream().forEach(deviceId -> {
      ShopDeviceOrderDO shopDeviceOrderDO = new ShopDeviceOrderDO();
      shopDeviceOrderDO.setDeviceId(deviceId);
      shopDeviceOrderDO.setShopId(shopId);
      shopDeviceOrderDOS.add(shopDeviceOrderDO);
    });
    return this.saveBatch(shopDeviceOrderDOS);
  }
}
