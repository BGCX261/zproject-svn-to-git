package com.zmis.core;

import java.util.List;

/**
 * 查询结果集
 * 
 * 2012-9-6 下午09:24:01
 * @author zlj
 * @param <T>
 */
public class QueryResult<T> {
	/**查询出来的分页记录*/
	private List<T> resultList;
	/**分页出来的总记录长度*/
	private long count;
	public QueryResult(){}
	
	public QueryResult(List<T> resultList, long count) {
		this.resultList = resultList;
		this.count = count;
	}
	
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	
	
}
