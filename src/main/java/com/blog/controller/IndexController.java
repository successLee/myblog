package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IndexController
 * 
 * @author sylar
 *
 */
@Controller
public class IndexController {
	
	/**
	 * 跳转首页
	 * @return
	 */
	@RequestMapping(value = "index")
	public String index() {
		return "index";
	}
}
