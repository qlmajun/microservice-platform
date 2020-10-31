package com.warrior.central.home.stay.controller.shop;

import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.home.stay.controller.shop.dto.ShopDTO;
import com.warrior.central.home.stay.service.shop.IShopService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author majun
 * @description 门店操作Controller
 * @date 2020/10/31
 */
@RestController
public class ShopController {

    @Autowired
    private IShopService shopService;

    @ApiOperation(value = "门店查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("/shops")
    public PageResult<ShopDTO> listShop(@RequestParam Map<String, Object> params){
        return shopService.listShop(params);
    }

    /**
     * 新增or更新
     *
     * @param shopDTO
     * @return
     */
    @PostMapping("/shops/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody ShopDTO shopDTO) throws Exception {
        return shopService.saveOrUpdateShop(shopDTO);
    }

    /**
     * 修改用户状态
     *
     * @param params
     * @return
     */
    @ApiOperation(value = "修改客户状态")
    @PostMapping("/shops/updateEnabled")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "enabled", value = "是否启用", required = true, dataType = "Boolean")
    })
    public Result updateEnabled(@RequestParam Map<String, Object> params) {
        return shopService.updateEnabled(params);
    }

}
