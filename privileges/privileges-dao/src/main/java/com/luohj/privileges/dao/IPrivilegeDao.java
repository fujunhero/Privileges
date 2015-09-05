package com.luohj.privileges.dao;

import java.util.Map;

import com.luohj.privileges.model.Module;
import com.luohj.privileges.model.Privilege;
import com.luohj.privileges.model.User;

public interface IPrivilegeDao {
    /**
     * 插入权限项
     * @param privi
     */
	public Long insertPrivilege(Privilege privi);
	/**
	 * 插入模块信息
	 * @param privi
	 */
	public Long insertModule(Module module);
    /**
     * 用户是否拥有当前权限
     * @param user
     * @param privi
     * @return
     */
	public boolean hasPrivilege(User user, Privilege privi, boolean isPriviExists);
	/**
     * 当前权限项是否存在
     * @param url
     * @return
     */
	public String isExistsPrivilegeItem(Privilege privi);
	/**
	 * 当前模块是否存在
	 * @param module
	 * @return
	 */
	public String isExistsModule(Module module);
}
