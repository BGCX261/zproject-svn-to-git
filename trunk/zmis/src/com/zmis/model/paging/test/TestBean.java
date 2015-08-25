package com.zmis.model.paging.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zmis.core.PageView;
import com.zmis.core.QueryResult;

public class TestBean {
	
	
	@Test
	public void testPageCount() {
		
		List<String> list = new ArrayList<String>();
		for(int i=0; i<121; i++) {
			list.add(""+i);
		}
		QueryResult<String> query = new QueryResult<String>(list, 123);
		
		PageView<String> pageView = new PageView<String>(7,12);
		pageView.setResults(query);
		
		System.out.println("记录总数"+pageView.getTotalRecord());
		System.out.println("记录页数"+pageView.getTotalPage());
		System.out.println("记录开始索引"+pageView.getStartIndex());
		System.out.println("记录结束索引"+pageView.getEndIndex());
		
		
	}
	
}
