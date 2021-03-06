package com.warrior.central.user.service;

import com.warrior.central.common.model.SysRole;
import com.warrior.central.common.service.ISuperService;
import com.warrior.central.user.model.SysRoleUserDO;

import java.util.List;

/**
 * 用户角色操作服务接口声明
 */
public interface IUserRoleService extends ISuperService<SysRoleUserDO> {

    /**
     * 根据用户id获取角色
     *
     * @param userId
     * @return
     */
    List<SysRole> findRolesByUserId(String userId);

    /**
     * 根据用户ids 获取
     *
     * @param userIds
     * @return
     */
    List<SysRole> findRolesByUserIds(List<String> userIds);

    /**
     * 删除用户角色
     *
     * @param userId 用户Id
     * @param roleId 角色Id
     * @return
     */
    int deleteUserRole(String userId, String roleId);
}
