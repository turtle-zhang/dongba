package com.turtle.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turtle.entity.SysUser;
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

	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysUser entity,Integer[] roleIds) {
		sysUserService.saveObject(entity, roleIds);
		return new JsonResult("保存成功");
	}

	/**
	 * 返回编辑界面的数据
	 * @param id
	 * @return
	 */
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		Map<String, Object> findObjectById = sysUserService.findObjectById(id);
		return new JsonResult(findObjectById);
	}


	/**
	 * 进行用户数据的更新
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysUser entity,Integer[] roleIds) {
		sysUserService.updateObject(entity, roleIds);
		return new JsonResult("更新成功");
	}

	/**
	 * 返回修改密码的界面
	 * @return
	 */
	@RequestMapping("doPwdEditUI")
	public String doPwdEditUI() {
		return "sys/pwd_edit";
	}

	/**
	 * 对用户密码进行修改
	 * @param pwd
	 * @param newPwd
	 * @param cfgPwd
	 * @return
	 */
	@RequestMapping("doUpdatePassword")
	@ResponseBody
	public JsonResult doUpdatePassword(String pwd,String newPwd,String cfgPwd) {
		sysUserService.updatePassword(pwd, newPwd, cfgPwd);
		return new JsonResult("更新成功");
	}

}




