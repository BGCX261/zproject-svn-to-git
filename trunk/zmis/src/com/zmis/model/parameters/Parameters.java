package com.zmis.model.parameters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.zmis.core.base.entity.BaseEntity;

/**
 * 系统参数设置
 * 
 * 2012-9-24 下午07:27:55
 * @author ricker.zlj
 */
@Entity
@Table(name="SYS_PARAMETERS")
public class Parameters extends BaseEntity {

	private int paraId;
	private String paraName;
	private String paraValue;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="param_id")
	public int getParaId() {
		return paraId;
	}
	public void setParaId(int paraId) {
		this.paraId = paraId;
	}
	
	@Column(name="param_name")
	public String getParaName() {
		return paraName;
	}
	public void setParaName(String paraName) {
		this.paraName = paraName;
	}
	
	@Column(name="param_value")
	public String getParaValue() {
		return paraValue;
	}
	public void setParaValue(String paraValue) {
		this.paraValue = paraValue;
	}
	
	@Transient
	public boolean isDelete() {
		return super.isDelete();
	}
}
