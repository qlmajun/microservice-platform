package com.warrior.central.home.stay.controller.room;

import com.warrior.central.common.constant.SecurityConstants;
import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.model.SysMenu;
import com.warrior.central.common.model.SysRole;
import com.warrior.central.home.stay.controller.room.dto.RoomTypeDTO;
import com.warrior.central.home.stay.service.room.IRoomTypeService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
     * @return
     */
    @GetMapping("/room/types")
    public PageResult<RoomTypeDTO> listRoomType(HttpServletRequest request){
        String shopId = request.getHeader(SecurityConstants.USER_SHOP_ID_HEADER);
        List<RoomTypeDTO> roomTypeDTOS = roomTypeService.listRoomType(shopId);
        return PageResult.<RoomTypeDTO>builder().data(roomTypeDTOS).code(0).count((long) roomTypeDTOS.size()).build();
    }

    /**
     * 删除房间类型
     * @param roomTypeId 房间类型Id
     * @return
     */
    @DeleteMapping("/room/types/{roomTypeId}")
    public Result removeRoomType(@PathVariable String roomTypeId){
        boolean success = roomTypeService.removeRoomType(roomTypeId);
        if(!success){
            return Result.failed("删除失败");
        }
        return Result.succeed("删除成功过");
    }

    @GetMapping("/shop/room/types")
    public Result<List<RoomTypeDTO>> listShopRoomType(HttpServletRequest request){
        String shopId = request.getHeader(SecurityConstants.USER_SHOP_ID_HEADER);
        List<RoomTypeDTO> roomTypeDTOS = roomTypeService.listRoomType(shopId);
        return Result.succeed(roomTypeDTOS);
    }

}
