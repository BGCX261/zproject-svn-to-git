package com.zmis.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zmis.core.system.config.SysConfig;

/**
 * 字符串 工具类
 * 
 * 2012-9-19 下午10:15:07
 * @author zlj
 */
public class StringUtil {
	private final static String FORMAT = (String) SysConfig.getValueByKey("date_format");
	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str==null || str.trim().length()==0){
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 时间格式化工具
	 * @param date
	 * @return
	 */
	public static String FormatDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
		return dateFormat.format(date);
	}
}
