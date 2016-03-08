package com.blog.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.base.BaseDao;
import com.blog.base.BaseServiceImpl;
import com.blog.core.util.LoginUtil;
import com.blog.dao.UserMapper;
import com.blog.model.User;
import com.blog.service.UserService;

/**
 * UserServiceImpl
 * 
 * @since 2016年2月1日 16:52:16
 * @author sylar
 *
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public BaseDao<User> getDao() {
		return userMapper;
	}

	@Override
	public User getByUsername(String username) {
		return userMapper.getByUsername(username);
	}

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByUsernameAndPassword(String username, String password, Date registerTime) {
		password = LoginUtil.encryptPassword(password, registerTime);
		return userMapper.getByUsernameAndPassword(username, password);
	}

}
