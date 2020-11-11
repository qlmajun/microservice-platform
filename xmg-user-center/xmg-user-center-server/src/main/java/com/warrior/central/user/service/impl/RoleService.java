package com.warrior.central.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.common.lock.DistributedLock;
import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.model.SysRole;
import com.warrior.central.common.service.impl.SuperServiceImpl;
import com.warrior.central.user.mapper.RoleMapper;
import com.warrior.central.user.mapper.RoleMenuMapper;
import com.warrior.central.user.mapper.UserRoleMapper;
import com.warrior.central.user.model.SysRoleDO;
import com.warrior.central.user.service.IRoleService;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author majun
 * @description
 * @date 2020/7/31
 */
@Service
public class RoleService extends SuperServiceImpl<RoleMapper, SysRoleDO> implements IRoleService {

    private final static String LOCK_KEY_ROLECODE = "rolecode:";

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Autowired
    private DistributedLock lock;

    @Override
    public List<SysRole> findAll(String shopId) {
        return roleMapper.findAll(shopId);
    }

    @Override
    public PageResult<SysRole> findRoles(Map<String, Object> params) {
        Integer curPage = MapUtils.getInteger(params, "page");
        Integer limit = MapUtils.getInteger(params, "limit");
        Page<SysRole> page = new Page<>(curPage == null ? 0 : curPage, limit == null ? -1 : limit);
        List<SysRole> list = roleMapper.findList(page, params);
        return PageResult.<SysRole>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    @Transactional
    public Result saveOrUpdateRole(SysRole sysRole) throws Exception {
        if (StringUtils.isEmpty(sysRole.getId())) {
            this.saveRole(sysRole);
        } else {
            SysRoleDO sysRoleDO = new SysRoleDO();
            BeanUtils.copyProperties(sysRole,sysRoleDO);
            baseMapper.updateById(sysRoleDO);
        }
        return Result.succeed("操作成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveRole(SysRole sysRole) throws Exception {
        String roleCode = sysRole.getCode();
        SysRoleDO sysRoleDO = new SysRoleDO();
        BeanUtils.copyProperties(sysRole,sysRoleDO);
        super.saveIdempotency(sysRoleDO, lock
                , LOCK_KEY_ROLECODE + roleCode, new QueryWrapper<SysRoleDO>().eq("code", roleCode), "角色code已存在");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteRole(String id) {
        baseMapper.deleteById(id);
        roleMenuMapper.delete(id, null);
        userRoleMapper.deleteUserRole(null, id);
    }
}
