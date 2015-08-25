package com.zmis.utils;

import javax.persistence.Entity;

/**
 * 类操作工具类
 * 
 * 2012-8-21 下午10:00:50
 * @author zlj
 */
public class ClassUtils {
	
	public static <T> String getClassName(Class<T> entityClass) {
		String className = entityClass.getSimpleName();
		Entity entity = entityClass.getAnnotation(Entity.class);
		if(entity!=null && !"".equals(entity.name())) {
			className = entity.name();
		}
		return className;
	} 
	
}
