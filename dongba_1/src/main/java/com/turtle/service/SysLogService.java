package com.turtle.service;

import com.turtle.vo.PageObject;
import com.turtle.entity.SysLog;

/**
 * 这个是对于日志操作的业务处理层
 * @author Administrator
 *
 */
public interface SysLogService {
	
	/**
	 * 通过此方法实现分页查询操作
	 * @param username 基于条件查询时的参数名
	 * @param pageCurrent 当前的页码值
	 * @return 当前页记录+分页信息
	 */
	PageObject<SysLog> findPageObjects(String username, Integer pageCurrent);
	
	/**
	 * 通过1~n多个ID来删除对应的日志信息
	 * @param id
	 * @return
	 */
	int deleteObjects(Integer...ids);
}
