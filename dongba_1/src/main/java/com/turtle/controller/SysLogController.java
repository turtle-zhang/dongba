package com.turtle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turtle.entity.SysLog;
import com.turtle.service.SysLogService;
import com.turtle.vo.JsonResult;
import com.turtle.vo.PageObject;

@Controller
@RequestMapping("/log/")
public class SysLogController {
	
	@Autowired
	private SysLogService sysLogService;
		
	/**
	 * 返回的是显示日志信息的页面
	 * @return
	 */
	@RequestMapping("doLogListUI")
	public String doLogListUI() {
		return "sys/log_list";
	}
	
	/**
	 * 将数据返回给前端，让其进行显示
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
		PageObject<SysLog> findPageObjects = sysLogService.findPageObjects(username, pageCurrent);		
		return new JsonResult(findPageObjects);
	}
	
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer...idArray) {
		sysLogService.deleteObjects(idArray);
		return new JsonResult("删除成功！！！");
	}
}
