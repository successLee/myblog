package com.blog.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SessionFactoryTest {

	private ApplicationContext ac;

	@Test
	public void sessionFactoryTest() {
		ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		SqlSessionFactory factory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
		factory.openSession();
	}
}
