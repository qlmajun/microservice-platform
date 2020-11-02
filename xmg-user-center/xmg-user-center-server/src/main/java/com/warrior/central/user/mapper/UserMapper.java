package com.warrior.central.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.common.model.SysUser;
import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.user.model.SysUserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户表 Mapper 接口
 */
@Mapper
public interface UserMapper extends SuperMapper<SysUserDO> {

    /**
     * 分页查询用户列表
     * @param page
     * @param shopId
     * @param params
     * @return
     */
    List<SysUser> findList(Page<SysUser> page,@Param("shopId") String shopId, @Param("u") Map<String, Object> params);
}
