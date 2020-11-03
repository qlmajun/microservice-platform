package com.warrior.central.home.stay.controller.shop;

import com.warrior.central.common.model.Result;
import com.warrior.central.home.stay.service.shop.IShopDeviceOrderService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mj
 * @date 2020/11/3
 */
@RestController
public class ShopDeviceOrderController {

  @Autowired
  private IShopDeviceOrderService shopDeviceOrderService;

  /**
   * 设备销售
   * @param shopId 门店Id
   * @param deviceIds 设备Id,多个设备使用逗号分隔
   * @return
   */
  @PostMapping("/shop/devices/order")
  public Result saleDevices(String shopId,String deviceIds){
    List<String> deviceIdList = Arrays.asList(deviceIds.split(","));
    boolean success = shopDeviceOrderService.saleDevices(shopId,deviceIdList);
    if(!success){
      return Result.failed("销售失败");
    }
    return Result.succeed("销售成功");
  }
}
