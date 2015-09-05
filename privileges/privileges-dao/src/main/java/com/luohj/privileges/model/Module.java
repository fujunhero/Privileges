package com.luohj.privileges.model;

import com.luohj.privileges.core.model.BaseBean;
import com.luohj.privileges.core.tags.Column;
import com.luohj.privileges.core.tags.Table;

/**
 * 功能说明:
 *
 * @author luohj
 * 
 * @Date 2015-9-5 上午11:34:27
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
@Table("TB_MODULE")
public class Module extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2576154713274934738L;
	@Column(value="MODULE_ID",id=true)
	private Long moduleId;
	@Column("MODULE")
	private String module;
	@Column("PAR_MODULE_ID")
	private Long parModuleId;
	@Column("PAR_MODULE")
	private String parModule;
	@Column("MODULE_DESC")
	private String moduleDesc;
	@Column("MODULE_TYPE")
	private String moduleType;
	@Column("CREATE_DATE")
	private String createDate;

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Long getParModuleId() {
		return parModuleId;
	}

	public void setParModuleId(Long parModuleId) {
		this.parModuleId = parModuleId;
	}

	public String getParModule() {
		return parModule;
	}

	public void setParModule(String parModule) {
		this.parModule = parModule;
	}

	public String getModuleDesc() {
		return moduleDesc;
	}

	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}

	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
