package com.warrior.central.common.model;

import java.util.List;
import lombok.Data;

/**
 * 用户实体
 * @author xmg
 */
@Data
public class SysUser extends SuperEntity {
	private static final long serialVersionUID = -5886012896705137070L;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 头像地址
	 */
	private String headImgUrl;

	/**
	 * 电话号码
	 */
	private String mobile;

	/**
	 * 性别
	 */
	private Integer sex;

	/**
	 * 可用状态
	 */
	private Boolean enabled;

	/**
	 * 类型
	 */
	private String type;

	/**
	 * openId
	 */
	private String openId;

	/**
	 * 删除状态
	 */
	private boolean isDel;

	/**
	 * 门店Id
	 */
	private String shopId;

	/**
	 * 角色
	 */
	private List<SysRole> roles;

	/**
	 * 角色Id
	 */
	private String roleId;

	/**
	 * 旧密码
	 */
	private String oldPassword;

	/**
	 * 新密码
	 */
	private String newPassword;
}
