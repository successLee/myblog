package com.blog.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.blog.core.util.LoginUtil;
import com.blog.model.User;
import com.blog.service.UserService;

/**
 * UserController
 * 
 * @author sylar
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@Resource
	private HttpServletRequest request;

	@ModelAttribute("/user")
	private User getUser() {
		return new User();
	}

	private static Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "toReg", method = RequestMethod.GET)
	public String showRegisterForm() {
		return "user/register";
	}

	@RequestMapping(value = "reg", method = RequestMethod.POST)
	public String submitRegistForm(@RequestParam MultipartFile usericon, @RequestParam String password2, @Valid User user, BindingResult result, ModelMap map) {
		if (result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError error : fieldErrors) {
				request.setAttribute("ERR_" + error.getField(), error.getDefaultMessage());
			}
			return showRegisterForm();
		}

		if (!user.getPassword().equals(password2.trim())) {
			request.setAttribute("ERR_password2", "两次输入密码不一致!");
			return showRegisterForm();
		}

		//上传用户头像
		if (usericon != null) {
			String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "/upload/";
			String fileName = usericon.getOriginalFilename();

			File uploadDir = new File(uploadUrl);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}

			File targetFile = new File(uploadDir + "/" + fileName);
			if (!targetFile.exists()) {
				try {
					targetFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
					return showRegisterForm();
				}
			}
			try {
				usericon.transferTo(targetFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return showRegisterForm();
			}
			user.setIconpath("/upload/" + fileName);
		}
		
		Date registerTime = new Date();
		user.setRegisterTime(registerTime);
		user.setPassword(LoginUtil.encryptPassword(password2, registerTime));

		try {
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return showRegisterForm();
		}

		return "redirect:/success.do";
	}

	@RequestMapping(value = "toLogin", method = RequestMethod.GET)
	public String showLoginForm() {
		return "user/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String doLoginForm(@RequestParam String username, @RequestParam String password, @RequestParam String code) {
		if (username == null || username.trim().isEmpty()) {
			request.setAttribute("ERR_username", "用户名不能为空");
			return showLoginForm();
		}
		if (password == null || password.trim().isEmpty()) {
			request.setAttribute("ERR_password", "密码不能为空");
			return showLoginForm();
		}
		if (code == null || code.trim().isEmpty()) {
			request.setAttribute("ERR_code", "验证码不能为空");
			return showLoginForm();
		}

		try {
			User user = userService.getByUsername(username);
			if (user == null) {
				request.setAttribute("ERR_user", "用户名不存在");
				return showLoginForm();
			}

			User loginUser = userService.getByUsernameAndPassword(username, password, user.getRegisterTime());
			if (loginUser == null) {
				request.setAttribute("ERR_user", "用户名密码错误");
				return showLoginForm();
			}

			loginUser.setLastloginTime(new Date());
			userService.update(loginUser);

			logger.info("UserController--------:" + loginUser);
			request.getSession().setAttribute("user", loginUser);
			return "redirect:/index.do";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("ERR_login", "登陆异常");
			return showLoginForm();
		}
	}

	@RequestMapping(value = "logout")
	public String logout() {
		request.getSession().removeAttribute("user");
		return "redirect:/index.do";
	}
}
