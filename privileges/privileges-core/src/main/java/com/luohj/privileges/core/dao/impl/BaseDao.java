package com.luohj.privileges.core.dao.impl;


import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.luohj.privileges.core.dao.IBaseDao;

/**
 * 功能说明:
 * 
 * @author luohj
 * 
 * @Date 2015-9-4 下午08:00:51
 * 
 * 
 *       版本号 | 作者 | 修改时间 | 修改内容
 * 
 */
public class BaseDao implements IBaseDao {
//	public static JdbcTemplate jdbc;
//	
//	static{
//		if (jdbc == null) {
//			// 给类加锁 防止线程并发
//			synchronized (BaseDao.class) {
//				if (jdbc == null) {
//					jdbc = (JdbcTemplate) ApplicationContextUtil.getBean("jdbcTemplate");
//				}
//			}
//		}
//	}
	@Resource
	private SqlMapClientTemplate sqlClient;

	public SqlMapClientTemplate getSqlClient() {
		return sqlClient;
	}

	public void setSqlClient(SqlMapClientTemplate sqlClient) {
		this.sqlClient = sqlClient;
	}
	
}
