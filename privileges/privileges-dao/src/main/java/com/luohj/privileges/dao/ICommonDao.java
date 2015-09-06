package com.luohj.privileges.dao;


import com.luohj.privileges.core.dao.IBaseDao;
import com.luohj.privileges.core.model.BaseBean;

public interface ICommonDao extends IBaseDao {
	public void insertBean(BaseBean bean);
	public boolean isExistsBean(BaseBean bean);
}
