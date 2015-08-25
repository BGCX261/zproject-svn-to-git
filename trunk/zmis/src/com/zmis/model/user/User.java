package com.zmis.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alibaba.fastjson.annotation.JSONField;
import com.zmis.core.base.entity.BaseEntity;
import com.zmis.utils.Digest;

@Entity(name="sysUser")
@Table(name="SYS_USER")
public class User extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userId;
    private String userName;
    private String userPwd;
    private int employeeId;
    /**当前登录IP地址*/
    private String IP;
    public User() {}
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Transient
	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	@Column(name="employee_id")
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	@Column(name="user_name", length=50, nullable=false, unique=true)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="user_pwd", length=64)
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		// 用户密码加密 加密//2012.9.17
		String pwd = Digest.shaHexEncode(userPwd);
		this.userPwd = pwd;
	}
	
}