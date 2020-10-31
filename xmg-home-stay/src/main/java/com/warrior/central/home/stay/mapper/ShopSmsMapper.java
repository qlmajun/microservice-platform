package com.warrior.central.home.stay.mapper;

import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.model.ShopSmsDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 门店短信记录表数据库操作接口声明
 */
@Mapper
public interface ShopSmsMapper extends SuperMapper<ShopSmsDO> {
}
