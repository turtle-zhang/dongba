package com.turtle.common.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turtle.vo.JsonResult;

/**
 * 定义了这个是一个全局的异常捕捉处理类
 * @author Administrator
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(RuntimeException e) {
		e.printStackTrace();
		// 到时将错误信息写入文件中进行保存
		return new JsonResult(e);
	}
}