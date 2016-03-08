package com.blog.service;

import java.util.Date;

import com.blog.base.BaseService;
import com.blog.model.User;

/**
 * UserService
 * @since 2016年2月1日 11:58:20
 * @author sylar
 *
 */
public interface UserService extends BaseService<User> {

	/**
	 * 通过username查询user
	 */
	User getByUsername(String username);

	/**
	 * 通过email查询user
	 */
	User getByEmail(String email);
	
	/**
	 * 用户登录使用
	 * @param username
	 * @param password
	 * @return
	 */
	User getByUsernameAndPassword(String username, String password, Date registerTime);
}
