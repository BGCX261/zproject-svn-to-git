package com.zmis.test;

import org.junit.Test;

import com.zmis.utils.Digest;



/**
 * 测试方法的调用
 * 
 * 2012-9-19 下午10:52:28
 * @author zlj
 */
public class TestPwd {
	public static void main(String[] args) {
		System.out.println(Digest.base64Decode("c265e4bd629300c543e6a06699c9efae51ffde2060b6e549".getBytes()));;
	}
	
	
	@Test
	public void testThrow() {
		try {
			int i = 1/0;
			System.out.println(i);
		} catch (Exception e) {
			System.out.println(e.toString());;
		}
	}
}
