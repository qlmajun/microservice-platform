package com.warrior.central.home.stay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.common.lock.DistributedLock;
import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.model.SysUser;
import com.warrior.central.common.service.impl.SuperServiceImpl;
import com.warrior.central.home.stay.controller.shop.dto.ShopDTO;
import com.warrior.central.home.stay.mapper.ShopMapper;
import com.warrior.central.home.stay.model.ShopDO;
import com.warrior.central.home.stay.service.IShopService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author majun
 * @description 门店操作服务接口实现
 * @date 2020/10/31
 */
@Service
public class ShopService extends SuperServiceImpl<ShopMapper, ShopDO> implements IShopService {

    private final static String LOCK_KEY_SHOP_NAME = "shopName:";

    @Autowired
    private DistributedLock lock;

    @Resource
    private ShopMapper shopMapper;

    @Override
    public PageResult<ShopDTO> listShop(Map<String, Object> params) {
        Page<ShopDO> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        //获取门店信息
        List<ShopDO> shopDOList =shopMapper.listShop(page,params);
        List<ShopDTO> shopDTOS = new ArrayList<>(shopDOList.size());
        shopDOList.stream().forEach(shopDO -> {
            ShopDTO shopDTO = new ShopDTO();
            BeanUtils.copyProperties(shopDO,shopDTO);
            shopDTOS.add(shopDTO);
        });
        return PageResult.<ShopDTO>builder().data(shopDTOS).code(0).count(page.getTotal()).build();
    }

    @Override
    public Result saveOrUpdateShop(ShopDTO shopDTO) throws Exception {
        ShopDO shopDO = new ShopDO();
        BeanUtils.copyProperties(shopDTO,shopDO);
        boolean result = super.saveOrUpdateIdempotency(shopDO, lock
                , LOCK_KEY_SHOP_NAME + shopDO.getName(), new QueryWrapper<ShopDO>().eq("name", shopDO.getName())
                , shopDO.getName() + "已存在");
        return result ? Result.succeed(shopDO, "操作成功") : Result.failed("操作失败");
    }
}
