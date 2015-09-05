package com.luohj.privileges.dao.impl;

import org.springframework.stereotype.Service;

import com.luohj.privileges.core.dao.impl.BaseDao;
import com.luohj.privileges.core.tags.Cacheable;
import com.luohj.privileges.dao.IUserDao;
import com.luohj.privileges.model.User;

@Service
public class UserDaoImpl extends BaseDao implements IUserDao  {

	@Cacheable(key="#userId")
	@Override
	public User getUser(String userId) {
		User user = (User)getSqlClient().queryForObject("systemMgr.getUser",userId);
		return user;
	}

}
