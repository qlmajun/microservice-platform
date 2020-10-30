package com.warrior.central.user.service;

import com.warrior.central.common.model.SysMenu;
import com.warrior.central.common.service.ISuperService;
import com.warrior.central.user.model.SysRoleMenuDO;

import java.util.List;
import java.util.Set;

/**
 * 角色菜单操作服务接口声明
 */
public interface IRoleMenuService extends ISuperService<SysRoleMenuDO> {

    /**
     * 根据角色编码和类型获取菜单项
     *
     * @param roleCodes 角色编码
     * @param type      类型
     * @return
     */
    List<SysMenu> findMenusByRoleCodes(Set<String> roleCodes, Integer type);

    /**
     * 根据角色Id和类型获取菜单项
     *
     * @param roleIds 角色Id
     * @param type    类型
     * @return
     */
    List<SysMenu> findMenusByRoleIds(Set<String> roleIds, Integer type);

    /**
     * 删除角色菜单
     *
     * @param roleId 角色Id
     * @param menuId 菜单Id
     * @return
     */
    int delete(String roleId, String menuId);
}
