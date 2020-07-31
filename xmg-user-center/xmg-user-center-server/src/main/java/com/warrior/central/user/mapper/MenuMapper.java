package com.warrior.central.user.mapper;

import com.warrior.central.common.model.SysMenu;
import com.warrior.central.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper extends SuperMapper<SysMenu> {
}
