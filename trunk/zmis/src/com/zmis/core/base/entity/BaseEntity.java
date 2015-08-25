package com.zmis.core.base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseEntity {
	/**数据输入日期*/
	protected Date inputDate = new Date();
	/**数据是否删除*/
	protected boolean delete = false;
	/**记录是否激活*/
	protected boolean active = true;
	/**备注*/
	protected String remark;
	
	@Column(name="input_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	
	@Column(name="is_delete")
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	
	@Column(name="is_active")
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
