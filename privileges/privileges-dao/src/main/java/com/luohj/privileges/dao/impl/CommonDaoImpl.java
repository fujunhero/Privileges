package com.luohj.privileges.dao.impl;


import java.lang.reflect.Field;

import com.luohj.privileges.core.dao.impl.BaseDao;
import com.luohj.privileges.core.exception.BusiRuntimeException;
import com.luohj.privileges.core.model.BaseBean;
import com.luohj.privileges.core.tags.Column;
import com.luohj.privileges.core.tags.Table;
import com.luohj.privileges.dao.ICommonDao;

public class CommonDaoImpl extends BaseDao implements ICommonDao {

	public void insertBean(BaseBean bean){
		Table tb = bean.getClass().getAnnotation(Table.class);
		if (tb == null) {
			throw new BusiRuntimeException("E00002", bean.getClass().getName()
					+ ":当前BEAN不是一个ENTITY，请添加@Table标记");
		}
		String tableName = tb.value();
		String idName = "";

        // 获取属性
		Field[] fields = bean.getClass().getDeclaredFields();
        String[] dbColumnNameArr = new String[fields.length];
        String[] values = new String[fields.length];
        int i = 0;
        for (int cnt = 0; cnt < fields.length; cnt++)
        {
        	Field field = fields[cnt];   
        	Column column  = field.getAnnotation(Column.class );//得到属性上的注解  
        	if(column!=null){
	        	String dbColumnName = column.value();
				if(column.id()){//如果此项是ID序列项，标记为空！
					idName = dbColumnName;
				}
	        	dbColumnNameArr[i] = dbColumnName;
	            // 获取属性的名字
	            String name = field.getName();
	            try {
	                field.setAccessible(true);//可以访问私有变量  
					Object value = field.get(bean);
					if(value!=null)
						values[i] = value.toString();
					else
						values[i] = null;
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
        	}
        }
        String sql = createInsertSql(dbColumnNameArr, values, tableName, idName);
        //判断存在！
		getSqlClient().insert("common.insertBean",sql);
	}
	
	public String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(
					Character.toUpperCase(s.charAt(0))).append(s.substring(1))
					.toString();
	}

	private String createInsertSql(String[] dbColumnNameArr, String[] values,
			String tableName, String idName) {
		StringBuffer sql = new StringBuffer();
		String dbColumnStr = "";
		String valueColumnStr = "";
		for (int i = 0; i < dbColumnNameArr.length; i++) {
			if (values[i] != null
					|| (dbColumnNameArr[i] != null && dbColumnNameArr[i]
							.equals(idName))) {
				if(dbColumnNameArr[i].equals(idName)){
					if (i == 0) {
						dbColumnStr = dbColumnNameArr[i];
						valueColumnStr =  "null" ;
					} else {
						dbColumnStr = dbColumnStr + "," + dbColumnNameArr[i];
						valueColumnStr = valueColumnStr + ", null" ;
					}
				}else{
					if (i == 0) {
						dbColumnStr = dbColumnNameArr[i];
						valueColumnStr = "'" + values[i] + "'";
					} else {
						dbColumnStr = dbColumnStr + "," + dbColumnNameArr[i];
						valueColumnStr = valueColumnStr + ", '" + values[i] + "'";
					}
				}
			}
		}
		sql.append("insert into ").append(tableName).append("(").append(
				dbColumnStr).append(")").append(" values ").append("(").append(
				valueColumnStr).append(")");
		return sql.toString();
	}
}
