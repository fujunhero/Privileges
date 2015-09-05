package com.luohj.privileges.model;

import com.luohj.privileges.core.exception.BusiRuntimeException;
import com.luohj.privileges.core.model.BaseBean;
import com.luohj.privileges.core.tags.Column;
import com.luohj.privileges.core.tags.Table;

/**
 * 功能说明:
 * 
 * @author luohj
 * 
 * @Date 2015-9-4 上午01:16:03
 * 
 * 
 * 版本号 | 作者 | 修改时间 | 修改内容
 * 
 */
@Table("tb_privilege")
public class Privilege extends BaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3470099375960839705L;
	/**
	 * 权限编码
	 */
	@Column(value="PRIVILEGE", id=true)
	private String privilege;
	/**
	 * 权限Id
	 */
	@Column("PRIVILEGE_ID")
	private Long privilegeId;
	/**
	 * 请求URL
	 */
	@Column("URL")
	private String url;
	/**
	 * 权限模块
	 */
	@Column("MODULE")
	private String module;
	/**
	 * 权限模块 ID
	 */
	@Column("MODULE_ID")
	private Long moduleId;
	/**
	 * 权限子模块
	 */
	@Column("CHILD_MODULE")
	private String childModule;
	/**
	 * 权限子模块ID
	 */
	@Column("CHILD_MODULE_ID")
	private Long childModuleId;
	
	/**
	 * userId
	 */
	private Long userId;

	public Privilege() { }

	public Privilege(String uri) {
		if (uri != null) {
			if(uri.substring(0, 1).equals("/")){
				uri = uri.substring(1);
			}
			this.url = uri;
			// 解析URL 形式必须是module/childModule/privilege
			String[] s = uri.split("\\/");
			if(s==null||s.length!=3){
				throw new BusiRuntimeException("E0001",
						"当前请求非法，请求形式必须是:context + XXX1/XXX2/XXX3");
			}else{
				module = s[0];
				childModule = s[1];
				privilege = s[2];
			}
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getChildModule() {
		return childModule;
	}

	public void setChildModule(String childModule) {
		this.childModule = childModule;
	}

	public Long getChildModuleId() {
		return childModuleId;
	}

	public void setChildModuleId(Long childModuleId) {
		this.childModuleId = childModuleId;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public Long getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
