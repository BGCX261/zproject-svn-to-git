package com.zmis.test;

/**
 * 测试类方法加载顺序
 * 
 * 2012-10-22 下午11:24:28
 * @author ricker.zlj[271218983@qq.com]
 */
public class TestStatic extends Parent {
	{
		System.out.println("Son ..非静态代码块");
	}
	
	static {
		System.out.println("Son ..静态代码块");
	}
	
	public TestStatic() {
		System.out.println("Son ..构造方法");
	}
	
	public void commons() {
		System.out.println("普通方法");
	} 
	
	public static void main(String[] args) {
		System.out.println("main----syso");
		
		TestStatic static1 = new TestStatic();
		static1.commons();
	}
}


class Parent {
	{
		System.out.println("Parent ..非静态代码块");
	}
	
	static {
		System.out.println("Parent ..静态代码块");
	}
	
	public Parent() {
		System.out.println("Parent ..构造方法");
	}
	
}
