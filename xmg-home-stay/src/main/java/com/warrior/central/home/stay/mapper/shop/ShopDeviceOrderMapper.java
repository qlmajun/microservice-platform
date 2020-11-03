package com.warrior.central.home.stay.mapper.shop;

import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.model.shop.ShopDeviceOrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 门店设备订购表数据库操作接口声明
 */
@Mapper
public interface ShopDeviceOrderMapper extends SuperMapper<ShopDeviceOrderDO> {
}
