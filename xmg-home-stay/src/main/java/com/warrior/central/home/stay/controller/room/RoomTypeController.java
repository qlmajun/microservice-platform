package com.warrior.central.home.stay.controller.room;

import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.model.SysMenu;
import com.warrior.central.home.stay.controller.room.dto.RoomTypeDTO;
import com.warrior.central.home.stay.service.room.IRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author majun
 * @description 客房类型操作Controller
 * @date 2020/10/31
 */
@RestController
public class RoomTypeController {

    @Autowired
    private IRoomTypeService roomTypeService;

    /**
     * 新增or更新
     * @param roomTypeDTO
     * @return
     */
    @PostMapping("/room/types/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody RoomTypeDTO roomTypeDTO){
        return roomTypeService.saveOrUpdate(roomTypeDTO);
    }

    /**
     * 获取门店客房类型
     * @param shopId 门店Id
     * @return
     */
    @GetMapping("/room/types")
    public PageResult<RoomTypeDTO> listRoomType(String shopId){
        List<RoomTypeDTO> roomTypeDTOS = roomTypeService.listRoomType(shopId);
        return PageResult.<RoomTypeDTO>builder().data(roomTypeDTOS).code(0).count((long) roomTypeDTOS.size()).build();
    }

}
