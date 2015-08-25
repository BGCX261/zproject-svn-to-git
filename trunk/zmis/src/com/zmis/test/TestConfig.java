package com.zmis.test;

import org.junit.Test;

import com.zmis.core.system.config.SysConfig;

public class TestConfig {
	
	@Test
	public void testFileType() {
		System.out.println(SysConfig.getValueByKey("page_size"));
	}
	
	@Test
	public void isContainsKey() {
		System.out.println(SysConfig.isContainsKey("page_size"));
	}
	
	@Test
	public void isContainsValue() {
		System.out.println(SysConfig.isContainsValue("200"));
	}
}
