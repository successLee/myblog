package com.blog.test;

import java.util.Date;

import org.junit.Test;

import com.blog.core.util.LoginUtil;

public class LoginUtilTest {

	@Test
	public void encrypeTest() {
		String password = "123456";
		Date date = new Date();
		
		LoginUtil.encryptPassword(password, date);
	}
}
