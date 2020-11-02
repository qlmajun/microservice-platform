package com.warrior.central.home.stay.mapper.shop;

import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.model.ShopOrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 门店订单表数据库操作接口声明
 */
@Mapper
public interface ShopOrderMapper extends SuperMapper<ShopOrderDO> {
}
