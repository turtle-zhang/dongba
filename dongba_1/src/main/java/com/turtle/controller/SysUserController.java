package com.turtle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turtle.service.SysUserService;
import com.turtle.vo.JsonResult;

/**
 * 对用户的模块控制
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user/")
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 返回的是显示用户信息的界面
	 * @return
	 */
	@RequestMapping("doUserListUI")
	public String doUserListUI() {
		return "sys/user_list";
	}
	
	/**
	 * 返回所有数据给前端显示
	 * @return
	 */
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username, Integer pageCurrent) {		
		return new JsonResult(sysUserService.findPageObjects(username, pageCurrent));
	}
	
	/**
	 * 设置用户的权限
	 * @param id
	 * @param valid
	 * @return
	 */
	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(Integer id, Integer valid) {
		sysUserService.validById(id, valid, "admin");
		return new JsonResult("权限修改成功 ");
	}
	
	/**
	 * 返回用户信息编辑界面
	 * @return
	 */
	@RequestMapping("doUserEditUI")	
	public String doUserEditUI() {
		return "sys/user_edit";
	}
}




