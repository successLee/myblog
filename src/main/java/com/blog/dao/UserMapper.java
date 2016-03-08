package com.blog.dao;

import org.apache.ibatis.annotations.Param;

import com.blog.base.BaseDao;
import com.blog.model.User;

/**
 * UserDao
 * 
 * @since 2016年2月1日 10:45:39
 * @author sylar
 *
 */
public interface UserMapper extends BaseDao<User> {

	/**
	 * 通过username查询user
	 */
	User getByUsername(String username);

	/**
	 * 通过email查询user
	 */
	User getByEmail(String email);

	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User getByUsernameAndPassword(@Param(value = "username") String username, @Param(value = "password") String password);
}
