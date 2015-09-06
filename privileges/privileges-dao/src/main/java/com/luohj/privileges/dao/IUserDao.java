package com.luohj.privileges.dao;

import java.util.Map;

import com.luohj.privileges.core.dao.IBaseDao;
import com.luohj.privileges.model.User;

public interface IUserDao extends IBaseDao {
	public User getUser(User user);
}
