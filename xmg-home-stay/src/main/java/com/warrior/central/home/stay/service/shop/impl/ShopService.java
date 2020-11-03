package com.warrior.central.home.stay.service.shop.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.service.impl.SuperServiceImpl;
import com.warrior.central.home.stay.controller.shop.dto.ShopDTO;
import com.warrior.central.home.stay.mapper.shop.ShopMapper;
import com.warrior.central.home.stay.model.shop.ShopDO;
import com.warrior.central.home.stay.service.shop.IShopService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author majun
 * @description 门店操作服务接口实现
 * @date 2020/10/31
 */
@Service
@Slf4j
public class ShopService extends SuperServiceImpl<ShopMapper, ShopDO> implements IShopService {

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
        boolean result = super.saveOrUpdate(shopDO);
        return result ? Result.succeed(shopDO, "操作成功") : Result.failed("操作失败");
    }

    @Override
    public Result updateEnabled(Map<String, Object> params) {
        Long id = MapUtils.getLong(params, "id");
        Boolean enabled = MapUtils.getBoolean(params, "enableStatus");
        ShopDO shopDO = shopMapper.selectById(id);
        if (shopDO == null) {
            return Result.failed("客户不存在");
        }
        shopDO.setEnableStatus(enabled);
        shopDO.setUpdateTime(new Date());
        int i = baseMapper.updateById(shopDO);
        log.info("修改客户状态：{}", shopDO);
        return i > 0 ? Result.succeed(shopDO, "更新成功") : Result.failed("更新失败");
    }
}
