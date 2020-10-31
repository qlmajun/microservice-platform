package com.warrior.central.home.stay.service.shop;

import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.service.ISuperService;
import com.warrior.central.home.stay.controller.shop.dto.ShopDTO;
import com.warrior.central.home.stay.model.ShopDO;

import java.util.Map;

/**
 * 门店操作服务接口声明
 */
public interface IShopService extends ISuperService<ShopDO> {

    /**
     * 门店查询列表
     * @param params
     * @return
     */
    PageResult<ShopDTO> listShop(Map<String, Object> params);

    /**
     * 新增or更新门店
     * @param shopDTO
     * @return
     */
    Result saveOrUpdateShop(ShopDTO shopDTO) throws Exception;

    /**
     * 状态变更
     * @param params
     * @return
     */
    Result updateEnabled(Map<String, Object> params);
}
