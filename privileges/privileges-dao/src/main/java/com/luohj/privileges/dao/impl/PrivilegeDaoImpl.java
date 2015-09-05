package com.luohj.privileges.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.luohj.privileges.core.dao.impl.BaseDao;
import com.luohj.privileges.dao.IPrivilegeDao;
import com.luohj.privileges.model.Module;
import com.luohj.privileges.model.Privilege;
import com.luohj.privileges.model.User;

/**
 * 功能说明:
 * 
 * @author Administrator
 * 
 * @Date 2015-9-4 下午09:29:50
 * 
 * 
 * 版本号 | 作者 | 修改时间 | 修改内容
 * 
 */
@Service
public class PrivilegeDaoImpl extends BaseDao implements IPrivilegeDao {

	@Override
	public boolean hasPrivilege(User user, Privilege privi,
			boolean isPriviExists) {
		privi.setUserId(user.getUserId());
		if (isPriviExists) {// 判断是否有此权限项权限
			// 查询当前权限项是否有效（至少有一条在用状态的权限关系数据）
			String cnt = getPrivilegeRoleCnt(privi);
			if (cnt != null && Integer.valueOf(cnt) > 0) {
				// 有效权限项
				String temp = (String) (getSqlClient().queryForObject(
						"systemMgr.hasPrivilege", privi));
				if (temp != null && Integer.valueOf(temp) > 0) {
					return true;
				} else {
					return false;
				}
			}
		}
		// 根据模块权限判断
		String tmp1 = (String) (getSqlClient().queryForObject(
				"systemMgr.hasPrivilegeOfModule", privi));
		if (tmp1 != null && Integer.valueOf(tmp1) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Long insertPrivilege(Privilege privi) {
		String temp = isExistsPrivilegeItem(privi);
		if (temp == null || temp.equals("")) {
			return (Long) getSqlClient().insert("systemMgr.insertPrivilege");
		}
		return Long.valueOf(temp);
	}

	@Override
	public Long insertModule(Module module) {
		String temp = isExistsModule(module);
		if (temp == null || temp.equals("")) {
			return (Long) getSqlClient().insert("systemMgr.insertModule",
					module);
		}
		return Long.valueOf(temp);
	}

	@Override
	public String isExistsPrivilegeItem(Privilege privi) {
		return (String) (getSqlClient().queryForObject(
				"systemMgr.isExistsPrivilege", privi));
	}

	@Override
	public String isExistsModule(Module module) {
		return (String) (getSqlClient().queryForObject(
				"systemMgr.isExistsModule", module));
	}

	public String getPrivilegeRoleCnt(Privilege privi) {
		return (String) (getSqlClient().queryForObject(
				"systemMgr.getPrivilegeRoleCnt", privi));
	}

}
