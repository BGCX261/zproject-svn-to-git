package com.zmis.test;

import org.junit.Test;

import com.zmis.utils.Digest;

public class DigestTest{
	
	
	@Test
	public void testSHA() {
		String str1 = Digest.shaHexEncode("zhoulijun");
		String str2 = Digest.shaHexEncode("周利军");
		System.out.println(str1);
		System.out.println(str1.equals(str2));
		
		String s = Digest.Md5("sdf");
		System.out.println(s);
		
	}
	
}
