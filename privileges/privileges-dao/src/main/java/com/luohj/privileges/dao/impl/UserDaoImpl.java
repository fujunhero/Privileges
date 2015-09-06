package com.luohj.privileges.dao.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.luohj.privileges.core.dao.impl.BaseDao;
import com.luohj.privileges.core.tags.Cacheable;
import com.luohj.privileges.dao.IUserDao;
import com.luohj.privileges.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements IUserDao  {
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);

	public UserDaoImpl(){
		logger.debug("UserDaoImpl..........成功加载！！！");
	}
	
	@Cacheable(key="#1.userId")
	@Override
	public User getUser(User ur) {
		User user = (User)getSqlClient().queryForObject("systemMgr.getUser",ur.getUserId());
		return user;
	}

}
