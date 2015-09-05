package com.luohj.privileges.dao;

import com.luohj.privileges.core.dao.IBaseDao;
import com.luohj.privileges.model.User;

public interface IUserDao extends IBaseDao {
	public User getUser(String userId);
}
