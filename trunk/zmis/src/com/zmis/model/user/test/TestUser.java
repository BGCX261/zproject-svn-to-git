package com.zmis.model.user.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zmis.model.user.User;
import com.zmis.model.user.service.UserService;

public class TestUser {
	private ApplicationContext ac = null;
	@Before
	public void framework() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Test
	public void addUser() {
		UserService service = (UserService) ac.getBean("userServiceImpl");
		for(int i=0; i<101; i++) {
			User user = new User();
			user.setUserName("test"+i);
			user.setUserPwd("loveone");
			user.setEmployeeId(i);
			user.setInputDate(new Date());
			user.setRemark("remark.");
			service.saveUser(user);
		}
	}
	
	@Test
	public void testUser() {
		UserService service = (UserService) ac.getBean("userServiceImpl");
		User user = new User();
		user.setUserName("test2");
		user.setUserPwd("loveone");
		user.setEmployeeId(112);
		user.setInputDate(new Date());
		user.setRemark("remark.");
		service.saveUser(user);
	}
	
}	
