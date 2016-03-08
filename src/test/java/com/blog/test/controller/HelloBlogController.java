package com.blog.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloBlogController {

	@RequestMapping(value = "/hello")
	public ModelAndView helloTest() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "hellohello");
		mv.setViewName("hello");
		return mv;
	}
}
