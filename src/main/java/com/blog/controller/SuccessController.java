package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SuccessController
 * 
 * @author sylar
 *
 */
@Controller
public class SuccessController {

	@RequestMapping("success")
	public String success() {
		return "success";
	}
}
