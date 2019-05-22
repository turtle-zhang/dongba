package com.turtle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turtle.service.SysDeptService;
import com.turtle.vo.JsonResult;

/**
 * 对于部门表的对应操作
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/dept/")
public class SysDeptController {

	@Autowired
	private SysDeptService sysDeptService;

	/**
	 * 返回的是部门显示页面
	 * @return
	 */
	@RequestMapping("doDeptListUI")
	public String doDeptListUI() {
		return "sys/dept_list";
	}

	/**
	 * 将查询出来的部门信息返回给前端显示
	 * @return
	 */
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects() {
		return new JsonResult(sysDeptService.findObjects());
	}
}
