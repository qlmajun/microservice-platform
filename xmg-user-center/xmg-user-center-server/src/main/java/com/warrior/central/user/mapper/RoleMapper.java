package com.warrior.central.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.common.model.SysRole;
import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.user.model.SysRoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper extends SuperMapper<SysRoleDO> {

    List<SysRole> findAll(@Param("shopId") String shopId);

    List<SysRole> findList(Page<SysRole> page, @Param("r") Map<String, Object> params);
}
