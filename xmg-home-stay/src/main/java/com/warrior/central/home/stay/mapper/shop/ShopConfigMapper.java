package com.warrior.central.home.stay.mapper.shop;

import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.model.ShopConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 门店配置表数据库操作接口声明
 */
@Mapper
public interface ShopConfigMapper extends SuperMapper<ShopConfigDO> {
}
