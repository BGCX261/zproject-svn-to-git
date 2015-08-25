package com.zmis.core.system.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class SysConfig {
	private static Properties properties = new Properties();
	private static Logger log = Logger.getLogger(SysConfig.class);
	
	static {
		try {
			properties.load(SysConfig.class.getClassLoader().getResourceAsStream("com/zmis/config/config.properties"));
		} catch (IOException e) {
			log.error("---------文件找不到------------"+e.getMessage());
		}
	}
	
	public void reLoadProperties() {
		try {
			properties.load(SysConfig.class.getClassLoader().getResourceAsStream("com/zmis/config/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			log.error("---------文件找不到------------");
			e.printStackTrace();  
		}
	}
	
	/**
	 * 根据Key获取值[会判断是否含有Key]
	 * @param key properties中的Key
	 * @return
	 */
	public static Object getValueByKey(String key) {
		if(isContainsKey(key)){
			return properties.get(key);
		}else {
			return null;
		}
	}
	/**
	 * 是否包含Key
	 * @param key
	 * @return
	 */
	public static boolean isContainsKey(String key) {
		return properties.containsKey(key);
	}
	
	/**
	 * 是否包含Value
	 * @param value
	 * @return
	 */
	public static boolean isContainsValue(String value) {
		return properties.containsValue(value);
	}
}
