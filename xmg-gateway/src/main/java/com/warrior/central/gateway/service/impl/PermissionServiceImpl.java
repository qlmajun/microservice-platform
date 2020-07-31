package com.warrior.central.gateway.service.impl;

import com.warrior.central.auth2.common.service.impl.DefaultPermissionServiceImpl;
import com.warrior.central.common.model.SysMenu;
import com.warrior.central.server.api.IMenuServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 权限判断操作服务实现
 *
 * @author majun
 * @date 2020/7/28
 */
@Service("permissionService")
public class PermissionServiceImpl extends DefaultPermissionServiceImpl {

    @Autowired
    private IMenuServiceApi menuServiceApi;

    @Override
    public List<SysMenu> findMenuByRoleCodes(String roleCodes) {
        return menuServiceApi.findByRoleCodes(roleCodes);
    }

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        return hasPermission(authentication, request.getMethod(), request.getRequestURI());
    }
}
