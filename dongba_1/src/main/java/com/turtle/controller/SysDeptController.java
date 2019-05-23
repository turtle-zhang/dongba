package com.turtle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turtle.entity.SysDept;
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

	/**
	 * 通过id来删除部门表中的记录信息
	 * @param id
	 * @return
	 */
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		sysDeptService.deleteObject(id);
		return new JsonResult("删除成功");
	}

	/**
	 * 跳转到编辑/添加页面
	 * @return
	 */
	@RequestMapping("doDeptEditUI")	
	public String doDeptEditUI() {
		return "sys/dept_edit";
	}

	/**
	 * 返回部门的上下级菜单关系数据
	 * @return
	 */
	 @RequestMapping("doFindZTreeNodes")
	 @ResponseBody
	public JsonResult doFindZtreeDeptNodes() {
		return new JsonResult(sysDeptService.doFindZtreeDeptNodes());
	}
	 
	 /**
	  * 对菜单数据进行保存
	  * @param sysDept
	  * @return
	  */
	 @RequestMapping("doSaveObject")
	 @ResponseBody
	 public JsonResult doSaveObject(SysDept sysDept) {
		 sysDeptService.saveObject(sysDept);
		 return new JsonResult("保存成功");
	 }
	 
	 /**
	  * 对菜单表进行数据的更新操作
	  * @param sysDept
	  * @return
	  */
	 @RequestMapping("doUpdateObject")
	 @ResponseBody
	 public JsonResult doUpdateObject(SysDept sysDept) {
		 sysDeptService.updateObject(sysDept);
		 return new JsonResult("更新成功");
	 }

}
