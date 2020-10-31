package com.warrior.central.home.stay.service.room;

import com.warrior.central.common.model.Result;
import com.warrior.central.common.service.ISuperService;
import com.warrior.central.home.stay.controller.room.dto.RoomTypeDTO;
import com.warrior.central.home.stay.model.RoomTypeDO;

import java.util.List;

/**
 * 客房类型操作服务接口声明
 */
public interface IRoomTypeService extends ISuperService<RoomTypeDO> {

    /**
     * 新增或更新客房类型
     * @param roomTypeDTO
     * @return
     */
    Result saveOrUpdate(RoomTypeDTO roomTypeDTO);

    /**
     * 获取门店客房类型
     * @param shopId 门店Id
     * @return
     */
    List<RoomTypeDTO> listRoomType(String shopId);
}
