package com.blog.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blog.model.Article;
import com.blog.service.ArticleService;

/**
 * UserService测试类
 * 
 * @author sylar
 *
 */
public class ArticleServiceTest {

	private ApplicationContext ac;
	private SqlSessionFactory factory;
	private SqlSession session;
	private ArticleService service;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		factory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
		session = factory.openSession();
		service = (ArticleService) ac.getBean("articleServiceImpl");
	}

	@Test
	public void getByIdTest() {
		Article article = service.getById(Long.valueOf(1));
		System.out.println(article);
	}
	
	@After
	public void close() {
		session.close();
	}
}
