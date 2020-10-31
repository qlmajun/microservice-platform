package com.warrior.central.home.stay.service.room.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.service.impl.SuperServiceImpl;
import com.warrior.central.home.stay.controller.room.dto.RoomTypeDTO;
import com.warrior.central.home.stay.mapper.RoomTypeMapper;
import com.warrior.central.home.stay.model.RoomTypeDO;
import com.warrior.central.home.stay.service.room.IRoomTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author majun
 * @description 客房类型操作服务接口实现
 * @date 2020/10/31
 */
@Service
public class RoomTypeService extends SuperServiceImpl<RoomTypeMapper, RoomTypeDO> implements IRoomTypeService {

    @Resource
    private RoomTypeMapper roomTypeMapper;

    @Override
    public Result saveOrUpdate(RoomTypeDTO roomTypeDTO) {
        RoomTypeDO roomTypeDO = new RoomTypeDO();
        BeanUtils.copyProperties(roomTypeDTO,roomTypeDO);
        boolean result = super.saveOrUpdate(roomTypeDO);
        return result ? Result.succeed(roomTypeDO, "操作成功") : Result.failed("操作失败");
    }

    @Override
    public List<RoomTypeDTO> listRoomType(String shopId) {
        List<RoomTypeDO> roomTypeDOS = roomTypeMapper.selectList(new QueryWrapper<RoomTypeDO>().eq("shop_id",shopId));
        List<RoomTypeDTO> roomTypeDTOS = new ArrayList<>(roomTypeDOS.size());
        roomTypeDOS.stream().forEach(roomTypeDO -> {
            RoomTypeDTO roomTypeDTO = new RoomTypeDTO();
            BeanUtils.copyProperties(roomTypeDO,roomTypeDTO);
            roomTypeDTOS.add(roomTypeDTO);
        });
        return roomTypeDTOS;
    }
}
