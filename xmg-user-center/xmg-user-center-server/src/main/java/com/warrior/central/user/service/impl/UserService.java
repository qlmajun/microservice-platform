package com.warrior.central.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.common.constant.CommonConstant;
import com.warrior.central.common.lock.DistributedLock;
import com.warrior.central.common.model.LoginAppUser;
import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.model.SuperEntity;
import com.warrior.central.common.model.SysMenu;
import com.warrior.central.common.model.SysRole;
import com.warrior.central.common.model.SysUser;
import com.warrior.central.common.model.UserType;
import com.warrior.central.common.service.impl.SuperServiceImpl;
import com.warrior.central.user.mapper.RoleMenuMapper;
import com.warrior.central.user.mapper.UserMapper;
import com.warrior.central.user.model.SysRoleUserDO;
import com.warrior.central.user.model.SysUserDO;
import com.warrior.central.user.model.SysUserExcel;
import com.warrior.central.user.service.IUserRoleService;
import com.warrior.central.user.service.IUserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * 用户相关操作服务接口实现
 *
 * @author majun
 * @date 2020/7/27
 */
@Service
@Slf4j
public class UserService extends SuperServiceImpl<UserMapper, SysUserDO> implements IUserService {

    private final static String LOCK_KEY_USERNAME = "username:";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserRoleService userRoleService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private DistributedLock lock;

    @Override
    public LoginAppUser findByUsername(String username,String shopId) {
        SysUser user = this.selectByUsername(username,shopId);
        return getLoginAppUser(user);
    }

    @Override
    public LoginAppUser findByOpenId(String openId) {
        SysUser user = this.selectByOpenId(openId);
        return getLoginAppUser(user);
    }

    @Override
    public LoginAppUser findByMobile(String mobile) {
        SysUser user = this.selectByMobile(mobile);
        return getLoginAppUser(user);
    }

    @Override
    public SysUser selectByUsername(String username,String shopId) {
        QueryWrapper<SysUserDO> queryWrapper = new QueryWrapper<SysUserDO>();
        queryWrapper.eq("username", username);
        if(StringUtils.isNotEmpty(shopId)){
            queryWrapper.and(wrapper -> wrapper.eq("shop_id", shopId));
        }
        List<SysUserDO> users = baseMapper.selectList(queryWrapper);
        return getUser(users);
    }

    @Override
    public SysUser selectByOpenId(String openId) {
        List<SysUserDO> users = baseMapper.selectList(new QueryWrapper<SysUserDO>().eq("open_id", openId));
        return getUser(users);
    }

    @Override
    public SysUser selectByMobile(String mobile) {
        List<SysUserDO> users = baseMapper.selectList(new QueryWrapper<SysUserDO>().eq("mobile", mobile));
        return getUser(users);
    }

    @Override
    public LoginAppUser getLoginAppUser(SysUser sysUser) {
        if (sysUser == null) {
            log.warn(" sys user is null when get login app user");
            return null;
        }

        LoginAppUser loginAppUser = new LoginAppUser();
        BeanUtils.copyProperties(sysUser, loginAppUser);

        //根据用户获取用户角色信息
        List<SysRole> roles = userRoleService.findRolesByUserId(sysUser.getId());

        if (CollectionUtils.isEmpty(roles)) {
            return loginAppUser;
        }

        // 设置角色
        loginAppUser.setRoles(roles);

        //获取角色Id
        Set<String> roleIds = roles.parallelStream().map(SuperEntity::getId).collect(Collectors.toSet());

        //获取权限菜单
        List<SysMenu> menus = roleMenuMapper.findMenusByRoleIds(roleIds, CommonConstant.PERMISSION);

        if (!CollectionUtils.isEmpty(menus)) {
            Set<String> permissions = menus.parallelStream().map(p -> p.getPath())
                    .collect(Collectors.toSet());
            // 设置权限集合
            loginAppUser.setPermissions(permissions);
        }

        return loginAppUser;
    }

    @Override
    public PageResult<SysUser> findUsers(Map<String, Object> params,String shopId) {
        Page<SysUser> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        //查询获取用户信息
        List<SysUser> list = userMapper.findList(page,shopId,params);
        long total = page.getTotal();
        if (total > 0) {
            //获取所有的用户Id
            List<String> userIds = list.stream().map(SysUser::getId).collect(Collectors.toList());
            //获取用户角色信息
            List<SysRole> roles = userRoleService.findRolesByUserIds(userIds);
            list.forEach(u -> u.setRoles(roles.stream().filter(r -> !ObjectUtils.notEqual(u.getId(), r.getUserId()))
                    .collect(Collectors.toList())));
        }
        return PageResult.<SysUser>builder().data(list).code(0).count(total).build();
    }

    @Override
    public Result updatePassword(String id, String oldPassword, String newPassword) {
        SysUserDO sysUser = baseMapper.selectById(id);
        if (StrUtil.isNotBlank(oldPassword)) {
            if (!passwordEncoder.matches(oldPassword, sysUser.getPassword())) {
                return Result.failed("旧密码错误");
            }
        }
        if (StrUtil.isBlank(newPassword)) {
            newPassword = CommonConstant.DEF_USER_PASSWORD;
        }
        SysUserDO user = new SysUserDO();
        user.setId(id);
        user.setPassword(passwordEncoder.encode(newPassword));
        baseMapper.updateById(user);
        return Result.succeed("修改成功");
    }

    @Override
    public boolean delUser(String id) {
        userRoleService.deleteUserRole(id, null);
        return baseMapper.deleteById(id) > 0;
    }

    @Override
    public Result saveOrUpdateUser(SysUser sysUser) throws Exception {
        if (StringUtils.isEmpty(sysUser.getId())) {
            if (StringUtils.isBlank(sysUser.getType())) {
                sysUser.setType(UserType.BACKEND.name());
            }
            sysUser.setPassword(passwordEncoder.encode(CommonConstant.DEF_USER_PASSWORD));
            sysUser.setEnabled(Boolean.TRUE);
        }
        String username = sysUser.getUsername();
        SysUserDO userDO = new SysUserDO();
        BeanUtils.copyProperties(sysUser,userDO);
        boolean result = super.saveOrUpdateIdempotency(userDO, lock
                , LOCK_KEY_USERNAME + username, new QueryWrapper<SysUserDO>().eq("username", username)
                , username + "已存在");
        //更新角色
        if (result && StrUtil.isNotEmpty(sysUser.getRoleId())) {
            userRoleService.deleteUserRole(sysUser.getId(), null);
            List roleIds = Arrays.asList(sysUser.getRoleId().split(","));
            if (!CollectionUtils.isEmpty(roleIds)) {
                List<SysRoleUserDO> roleUsers = new ArrayList<>(roleIds.size());
                roleIds.forEach(roleId -> roleUsers.add(new SysRoleUserDO(userDO.getId(), roleId.toString())));
                userRoleService.saveBatch(roleUsers);
            }
        }
        return result ? Result.succeed(sysUser, "操作成功") : Result.failed("操作失败");
    }

    @Override
    public Result updateEnabled(Map<String, Object> params) {
        Long id = MapUtils.getLong(params, "id");
        Boolean enabled = MapUtils.getBoolean(params, "enabled");

        SysUserDO appUser = baseMapper.selectById(id);
        if (appUser == null) {
            return Result.failed("用户不存在");
        }
        appUser.setEnabled(enabled);
        appUser.setUpdateTime(new Date());

        int i = baseMapper.updateById(appUser);
        log.info("修改用户：{}", appUser);

        return i > 0 ? Result.succeed(appUser, "更新成功") : Result.failed("更新失败");
    }

    @Override
    public List<SysUserExcel> findAllUsers(Map<String, Object> params,String shopId) {
        List<SysUserExcel> sysUserExcels = new ArrayList<>();
        List<SysUser> list = baseMapper.findList(new Page<>(1, -1), shopId,params);

        for (SysUser sysUser : list) {
            SysUserExcel sysUserExcel = new SysUserExcel();
            BeanUtils.copyProperties(sysUser, sysUserExcel);
            sysUserExcels.add(sysUserExcel);
        }
        return sysUserExcels;
    }

    private SysUser getUser(List<SysUserDO> users) {
        SysUser user = null;
        if (users != null && !users.isEmpty()) {
            SysUserDO sysUserDO = users.get(0);
            user = new SysUser();
            BeanUtils.copyProperties(sysUserDO,user);
        }
        return user;
    }
}
