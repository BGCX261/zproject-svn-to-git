package com.zmis.core.base.dao;

import java.util.LinkedHashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zmis.core.QueryResult;
import com.zmis.utils.ClassUtils;

@Transactional
public abstract class BaseDaoSupport<T> implements BaseDao<T> {
	@PersistenceContext 
	protected EntityManager em;
	private Logger logger = Logger.getLogger(BaseDaoSupport.class);
	public void save(T entity) {
		System.out.println(em);
		em.persist(entity);
	}

	public void update(T entity) {
		em.merge(entity);
	}

	public void delete(Class<T> entityClass, Object entityId) {
		delete(entityClass, new Object[]{entityId});
	}

	public void delete(Class<T> entityClass, Object[] entitys) {
		for(Object entity:entitys) {
			em.remove(em.getReference(entityClass, entity));
		}
	}
	
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public T find(Class<T> entityclass, Object entityId) {
		return em.find(entityclass, entityId);
	}


	/**
	 * 查询数据最终实现方法
	 * @param entityClass 实体类
	 * @param startIndex 开始索引
	 * @param recordMax 每页中的最大记录数
	 * @param where where 查询条件(?index index从1开始)       id=?1 and name=?2 and sex=?3
	 * @param whereValue 查询条件值     
	 * @param orderBy 排序条件
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getData(Class<T> entityClass, int startIndex, int recordMax,
			String where,Object[] whereValue, LinkedHashMap<String, String> orderBy) {
		QueryResult<T> queryResult = new QueryResult<T>();
		String entityClassName = ClassUtils.getClassName(entityClass);
		String sql = "select o from "+entityClassName+" o "+(where==null || "".equals(where.trim())?"":"where "+where)+buildOrderBy(orderBy);
		logger.debug("-------拼接SQL-----"+sql);
		Query query = em.createQuery(sql);
		setQueryParams(query,whereValue);
		//分页 start
		if(startIndex != -1 && recordMax != -1) {
			query.setFirstResult(startIndex);
			query.setMaxResults(recordMax);
		}
		//存放结果集
		queryResult.setResultList(query.getResultList());
		query = em.createQuery("select count(o) from "+entityClassName+" o "+((where==null || "".equals(where.trim()))?"":"where "+where));
		setQueryParams(query,whereValue);
		queryResult.setCount((Long)query.getSingleResult());
		return queryResult;
	}
	/**
	 * 开始索引startIndex + 每页记录数pageSize + SQLwhere条件
	 */
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getData(Class<T> entityClass, int startIndex,
			int recordMax, String where, Object[] whereValue) {
		return getData(entityClass, startIndex, recordMax, where, whereValue, null);
	}
	/**
	 * 开始索引startIndex + 每页记录数PageSize + 排序 orderBy
	 */
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getData(Class<T> entityClass, int startIndex,
			int recordMax, LinkedHashMap<String, String> orderBy) {
		return getData(entityClass, startIndex, recordMax, null, null, orderBy);
	}
	/**
	 *  根据开始索引startIndex与每页记录数pageSize 得到数据
	 */
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getData(Class<T> entityClass, int startIndex,
			int recordMax) {
		return getData(entityClass, startIndex, recordMax, null, null, null);
	}
	
	/**
	 * 只根据where条件获取数据
	 */
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getData(Class<T> entityClass, String where, Object[] whereValue) {
		return getData(entityClass, -1, -1, where, whereValue, null);
	}
	
	/**
	 * 得到所有数据
	 */
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getData(Class<T> entityClass) {
		return getData(entityClass, -1, -1, null, null, null);
	}

	/**
	 * 设置SQL的where条件
	 * @param query 查询query
	 * @param queryParams query参数列表
	 */
	protected static void setQueryParams(Query query, Object[] queryParams) {
		if(queryParams !=null && queryParams.length>0) {
			for(int i=0; i<queryParams.length; i++) {
				query.setParameter(i+1, queryParams[i]);
			}
		}
	}
	/**
	 * 构建排序
	 * @param orderBy
	 * @return
	 */
	protected static String buildOrderBy(LinkedHashMap<String, String> orderBy) {
		StringBuffer sb = new StringBuffer("");
		if(orderBy != null && orderBy.size()>0) {
			sb.append(" order by ");
			for(String key: orderBy.keySet()) {
				sb.append("o.").append(key).append(" ").append(orderBy.get(key)).append(",");
			}
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
	 
}
