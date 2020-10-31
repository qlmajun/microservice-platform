package com.warrior.central.home.stay.controller.room.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author majun
 * @description 客房类型封装传输对象
 * @date 2020/10/31
 */
@Getter
@Setter
@ToString
public class RoomTypeDTO implements Serializable {
    private static final long serialVersionUID = 3303248231942811914L;

    /**
     * id
     */
    private String id;

    /**
     * 门店Id
     */
    private String shopId;

    /**
     * 类型名称
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
