package com.turtle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turtle.entity.SysRole;
import com.turtle.service.SysRoleService;
import com.turtle.vo.JsonResult;
import com.turtle.vo.PageObject;

/**
 * 这个是对角色信息的控制层操作的
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/role/")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 返回一个角色的界面
	 * @return
	 */
	@RequestMapping("doRoleListUI")
	public String doRoleListUI() {
		return "sys/role_list";
	}

	/**
	 * 返回一个显示编辑/添加角色的界面
	 * @return
	 */
	@RequestMapping("doRoleEditUI")
	public String doRoleEditUI() {
		return "sys/role_edit";
	}

	/**
	 * 返回给页面的详细信息
	 * @param name
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjets(String name, Integer pageCurrent) {
		PageObject<SysRole> findPageObjects = sysRoleService.findPageObjects(name, pageCurrent);
		return new JsonResult(findPageObjects);
	}

	/**
	 * 对角色信息进行删除操作
	 * @param id
	 * @return
	 */
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		sysRoleService.deleteObject(id);
		return new JsonResult("删除成功");
	}

	/**
	 * 添加角色信息
	 * @param sysRole
	 * @param menuIds
	 * @return
	 */
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysRole sysRole, Integer[]menuIds) {
		sysRoleService.saveObject(sysRole, menuIds);
		return new JsonResult("添加成功");
	}

	/**
	 * 将角色编辑界面要显示的数据传过去
	 * @param id
	 * @return
	 */
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		return new JsonResult(sysRoleService.findObjectById(id));
	}
	
	/**
	 * 更新角色数据
	 * @param sysRole
	 * @param menuIds
	 * @return
	 */
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysRole sysRole, Integer[]menuIds) {
		sysRoleService.updateObject(sysRole, menuIds);
		return new JsonResult("更新成功");
	}
	
	/**
	 * 返回出角色表中对应的数据
	 * @return
	 */
	@RequestMapping("doFindRoles")
	@ResponseBody
	public JsonResult doFindRoles() {
		return new JsonResult(sysRoleService.findObjects());
	}
}


















