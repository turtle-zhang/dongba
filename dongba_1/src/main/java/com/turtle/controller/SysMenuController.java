package com.turtle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turtle.entity.SysMenu;
import com.turtle.service.SysMenuService;
import com.turtle.vo.JsonResult;

/**
 * 这个是对菜单的数据管理操作
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/menu/")
public class SysMenuController {

	@Autowired
	private SysMenuService sysMenuService;
	
	/**
	 * 返回菜单页面
	 * @return
	 */
	@RequestMapping("doMenuListUI")
	public String doMenuListUI() {
		return "sys/menu_list";
	}
	
	/**
	 * 将菜单信息返回给前端显示
	 * @return
	 */
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects() {
		return new JsonResult(sysMenuService.findObjects());
	}
	
	/**
	 * 删除菜单信息记录，通过id来完成
	 * @param id
	 * @return
	 */
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		sysMenuService.deleteObject(id);
		return new JsonResult("菜单删除成功");
	}
	
	/**
	 * 返回编辑/添加菜单页面
	 * @return
	 */
	@RequestMapping("doMenuEditUI")
	public String doMenuEditUI() {
		return "sys/menu_edit";
	}
	
	/**
	 * 将查询出来的节点信息返回给前端
	 * @return
	 */
	@RequestMapping("doFindZtreeMenuNodes")
	@ResponseBody
	public JsonResult doFindZtreeMenuNodes() {
		return new JsonResult(sysMenuService.findZtreeMenuNodes());
	}
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysMenu sysMenu) {
		sysMenuService.saveObject(sysMenu);
		return new JsonResult("保存成功");
	}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysMenu sysMenu) {
		sysMenuService.updateObject(sysMenu);
		return new JsonResult("更新成功");
	}
}






















