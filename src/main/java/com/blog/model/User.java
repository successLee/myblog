package com.blog.model;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

import com.blog.controller.support.annotation.UsernameCheck;

/**
 * User model
 * 
 * @author sylar
 * @since 2016年1月29日 16:28:21
 */
public class User {

	private Long id;

	@UsernameCheck(message = "{username.not.illegal}")
	private String username;

	private String sex;

	@Pattern(regexp = "[a-zA-Z0-9]{5,20}", message = "{password.not.illegal}")
	private String password;

	private String password_salt;

	@Email
	private String email;

	private Date registerTime;

	private Date lastloginTime;

	/*用户头像路径*/
	private String iconpath;

	public User() {
	}

	public User(String username, String sex, String password, String password_salt, String email, Date registerTime, Date lastloginTime) {
		this.username = username;
		this.sex = sex;
		this.password = password;
		this.password_salt = password_salt;
		this.email = email;
		this.registerTime = registerTime;
		this.lastloginTime = lastloginTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword_salt() {
		return password_salt;
	}

	public void setPassword_salt(String password_salt) {
		this.password_salt = password_salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getLastloginTime() {
		return lastloginTime;
	}

	public void setLastloginTime(Date lastloginTime) {
		this.lastloginTime = lastloginTime;
	}

	public String getIconpath() {
		return iconpath;
	}

	public void setIconpath(String iconpath) {
		this.iconpath = iconpath;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", password=" + password + ", password_salt=" + password_salt + ", email=" + email + "]";
	}
}
