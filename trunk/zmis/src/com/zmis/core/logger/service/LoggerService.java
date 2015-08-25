package com.zmis.core.logger.service;

import org.apache.log4j.Logger;

import com.zmis.core.logger.bean.LoggerBean;


/**
 * <ul>
 * 	<li>增强日志处理</li>
 * 	<li>在log4j的基础上增加自定义的数据库日志保存, (通过一个)</li>
 * 2013-1-3 下午05:29:23
 * @author ricker.zlj[271218983@qq.com]
 * </ul>
 */
public class LoggerService {
	private LoggerBean log;
	public LoggerService(Class<?> clazz) {
		persistent(clazz, false);
	}
	
	/**
	 * 
	 * @param clazz 类字节码
	 * @param isSave 是否保存到数据库
	 */
	public LoggerService(Class<?> clazz, boolean isSave) {
		persistent(clazz, isSave);
	}
	
	/**
	 * 写操作(可阻塞队列)
	 */
	public void persistent(Class<?> clazz,boolean isSave) {
		
	}
}
