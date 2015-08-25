package com.zmis.core.logger.bean;

import java.util.Date;

/**
 * 
 * 2013-1-3 下午06:06:38
 * @author ricker.zlj[271218983@qq.com]
 */
public class LoggerBean {
	public int logId;   //日志编号
	public String logName;  //日志name
	public String logContext;  //日志内容
	public int lvl;            //日志级别
	public Date logDate;      //日志日期
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getLogContext() {
		return logContext;
	}
	public void setLogContext(String logContext) {
		this.logContext = logContext;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
}
