package com.zmis.core;


public class PageView<T> {
	/** 显示的记录集*/
	private QueryResult<T> results; 
	/**每页中记录数*/
	private int pageSize;
	/**当前页*/
	private int currentPage;
	
	private long totalPage;
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	

	/***得到总记录数*/
	public long getTotalRecord() {
		if(results != null) {
			totalPage = results.getCount();
		}else {
			totalPage = 0;
		}
		return totalPage;
	}

	/**
	 * 构造分页bean
	 * @param currentPage 当前是多少页
	 * @param pageSize 每页记录数
	 */
	public PageView(int currentPage,int pageSize) {
		this.pageSize= pageSize;
		if(pageSize<1) { 
			this.pageSize = 1;
		}else {
			this.pageSize = pageSize;
		}
		if(currentPage<1) {
			this.currentPage = 1;
		}else {
			this.currentPage = currentPage;
		}
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	//bean 当前页数
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		if(currentPage<1) {
			this.currentPage = 1;
		}else {
			this.currentPage = currentPage;
		}
	}
	
	public QueryResult<T> getResults() {
		return results;
	}

	public void setResults(QueryResult<T> results) {
		this.results = results;
	}
	
	
	public long getTotalPage() {
		return getTotalRecord()%pageSize==0 ? getTotalRecord()/pageSize : getTotalRecord()/pageSize+1;
	}
	
	/**得到开始索引*/
	public int getStartIndex() {
		return currentPage==1?0:(currentPage-1)*pageSize+1;
	}
	/**得到结束索引*/
	public int getEndIndex() {
		return currentPage==1?pageSize: currentPage*pageSize;
	}
}
