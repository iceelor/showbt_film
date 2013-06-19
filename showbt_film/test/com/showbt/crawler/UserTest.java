package com.showbt.crawler;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.showbt.crawler.bean.User;
import com.showbt.crawler.service.UserService;

public class UserTest {
	private ApplicationContext context;

	@Before
	public void before() {
		context =  new FileSystemXmlApplicationContext("WebRoot/WEB-INF/config/applicationContext.xml");
	}

	@Test
	public void test() {
		UserService userService =  (UserService) context.getBean("userService");
		User user = new User();
		user.setPassword("11122");
		user.setUsername("ddddddddd");
		userService.editSave(user);
		
		List<User> list = userService.queryAll(" from User");
		for (int i = 0; i < list.size(); i++) {
			User u = list.get(i);
			System.out.println(u.getUsername());
		}
	}
}
