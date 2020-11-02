package com.warrior.central.home.stay.mapper.shop;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.common.model.SysUser;
import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.home.stay.model.ShopDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 门店表数据库操作接口声明
 */
@Mapper
public interface ShopMapper extends SuperMapper<ShopDO> {

    /**
     * 分页获取门店信息
     * @param page
     * @param params
     * @return
     */
    List<ShopDO> listShop(Page<ShopDO> page, @Param("u")Map<String, Object> params);
}
