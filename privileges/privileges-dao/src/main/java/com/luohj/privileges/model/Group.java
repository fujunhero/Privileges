package com.luohj.privileges.model;

import com.luohj.privileges.core.model.BaseBean;
import com.luohj.privileges.core.tags.Column;
import com.luohj.privileges.core.tags.Table;

/**
 * 功能说明:
 * 
 * @author luohj
 * 
 * @Date 2015-9-5 上午11:34:34
 * 
 * 
 * 版本号 | 作者 | 修改时间 | 修改内容
 * 
 */
@Table("TB_GROUP")
public class Group extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1590298413434040447L;
	@Column(value = "GROUP_ID", id = true)
	private Long groupId;
	@Column(value = "GROUP_DESC")
	private String groupDesc;
	@Column(value = "CREATE_DATE")
	private String createDate;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
