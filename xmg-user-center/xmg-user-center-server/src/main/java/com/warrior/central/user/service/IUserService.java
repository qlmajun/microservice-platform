package com.warrior.central.user.service;

import com.warrior.central.common.model.LoginAppUser;
import com.warrior.central.common.model.PageResult;
import com.warrior.central.common.model.Result;
import com.warrior.central.common.model.SysUser;
import com.warrior.central.common.service.ISuperService;
import com.warrior.central.user.model.SysUserDO;
import com.warrior.central.user.model.SysUserExcel;
import java.util.List;
import java.util.Map;

/**
 * 用户操作服务接口声明
 */
public interface IUserService extends ISuperService<SysUserDO> {

    /**
     * 根据用户名获取用户登入信息
     *
     * @param username 用户名
     * @param shopId 门店Id
     * @return
     */
    LoginAppUser findByUsername(String username,String shopId);

    /**
     * 根据openId获取用户登入信息
     *
     * @param openId openId
     * @return
     */
    LoginAppUser findByOpenId(String openId);

    /**
     * 根据手机号获取用户登入信息
     *
     * @param mobile 手机号
     * @return
     */
    LoginAppUser findByMobile(String mobile);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @param shopId 门店Id
     * @return
     */
    SysUser selectByUsername(String username,String shopId);

    /**
     * 根据openId查询用户信息
     *
     * @param openId openId
     * @return
     */
    SysUser selectByOpenId(String openId);

    /**
     * 根据手机号查询用户信息
     *
     * @param mobile 手机号
     * @return
     */
    SysUser selectByMobile(String mobile);

    /**
     * 通过SysUser 转换为 LoginAppUser，把roles和permissions也查询出来
     *
     * @param sysUser
     * @return
     */
    LoginAppUser getLoginAppUser(SysUser sysUser);

    /**
     * 用户列表
     *
     * @param params
     * @param shopId 门店Id
     * @return
     */
    PageResult<SysUser> findUsers(Map<String, Object> params,String shopId);

    /**
     * 更新密码
     *
     * @param id          用户Id
     * @param oldPassword 原始密码
     * @param newPassword 新密码
     * @return
     */
    Result updatePassword(String id, String oldPassword, String newPassword);

    /**
     * 删除用户
     */
    boolean delUser(String id);

    /**
     * 新增or修改用户
     *
     * @param sysUser 用户信息
     * @return
     */
    Result saveOrUpdateUser(SysUser sysUser) throws Exception;

    /**
     * 状态变更
     * @param params
     * @return
     */
    Result updateEnabled(Map<String, Object> params);

    /**
     * 查询全部用户
     * @param params
     * @param shopId
     * @return
     */
    List<SysUserExcel> findAllUsers(Map<String, Object> params,String shopId);
}
