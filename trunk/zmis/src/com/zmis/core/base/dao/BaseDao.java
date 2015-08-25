package com.zmis.core.base.dao;

import java.util.LinkedHashMap;

import com.zmis.core.QueryResult;


/**
 * 通用DAO接口
 * 
 * 2012-8-13 12:41:21
 * @author zlj
 */
public interface BaseDao<T> {
	
	/**
	 * 保存
	 * @param entity ʵ�����
	 */
	public void save(T entity);
	
	/**
	 * 更新
	 * @param entity ʵ�����
	 */
	public void update(T entity);
	
	/**
	 * 删除
	 * @param entityClass ʵ����
	 * @param entitys
	 */
	public void delete(Class<T> entityClass, Object entity);
	
	/**
	 * 删除
	 * @param entityClass ʵ����
	 * @param entitys
	 */
	public void delete(Class<T> entityClass, Object[] entitys);
	
	
	/**
	 * 查找
	 * @param entityId ʵ��ID
	 * @return 
	 */
	public T find(Class<T> entityclass, Object entityId); 
	
	/**
	 * 得到分页条件
	 * @param startIndex 开始分页
	 * @param recordMax 每页中的最大记录数
	 * @param orderBy 排序   LinkedHashMap:不会对添加到里面的数据进行排序, 
	 * @return 分页返回的结果集
	 */
	public QueryResult<T> getData(Class<T> entityClass, int startIndex, int recordMax, 
			String where, Object[] whereValue, LinkedHashMap<String, String> orderBy);
	
	public QueryResult<T> getData(Class<T> entityClass, int startIndex, int recordMax, 
			String where, Object[] whereValue);
	
	public QueryResult<T> getData(Class<T> entityClass, int startIndex, int recordMax, 
			LinkedHashMap<String, String> orderBy);
	
	public QueryResult<T> getData(Class<T> entityClass, int startIndex, int recordMax);
	
	public QueryResult<T> getData(Class<T> entityClass, String where, Object[] whereValue);
	
	/**
	 * 
	 * @param entityClass
	 * @return
	 */
	public QueryResult<T> getData(Class<T> entityClass);
	
}
