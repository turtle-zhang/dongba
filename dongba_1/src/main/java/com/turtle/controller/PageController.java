package com.turtle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这个是用来返回一些通用的页面的
 * @author 22274
 *
 */
@Controller
@RequestMapping("/")
public class PageController {	
	
	/**
	 * 返回的是主页面
	 * @return
	 */
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";
	}
	
	/**
	 * 返回的是分页页面
	 * @return
	 */
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
}