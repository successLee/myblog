package com.blog.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blog.model.User;
import com.blog.service.UserService;

/**
 * UserService测试类
 * 
 * @author sylar
 *
 */
public class UserServiceTest {

	private ApplicationContext ac;
	private SqlSessionFactory factory;
	private SqlSession session;
	private String statement = "";
	private UserService service;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		factory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
		session = factory.openSession();
		service = (UserService) ac.getBean("userServiceImpl");
	}

	@Test
	public void saveTest() {
		statement = "com.blog.dao.UserMapper.save";
		User user = new User("test1", "female", "123456", "salt", "131810@a.com", null, null);
		session.insert(statement, user);
	}
	
	@Test
	public void saveTest2() {
		statement = "com.blog.dao.UserMapper.save";
		User user = new User("test2", "male", "aaabbb", "1salt", "a131810@a.com", null, null);
//		session.insert(statement, user);
		service.save(user);
	}

	@Test
	public void updateTest() {
		statement = "com.blog.dao.UserMapper.update";
		User user = new User("test11111e", "", "", "", "", null, null);
		user.setId(Long.valueOf(2));
		session.update(statement, user);
	}

	@Test
	public void getTest() {
		statement = "com.blog.dao.UserMapper.getById";
		User user = session.selectOne(statement, Long.valueOf(1));
		System.out.println(user);
	}

	@Test
	public void getAllTest() {
		statement = "com.blog.dao.UserMapper.getAll";
		List<User> users = session.selectList(statement);
		for (User user : users) {
			System.out.println(user);
		}
	}

	@After
	public void close() {
		session.close();
	}
}
