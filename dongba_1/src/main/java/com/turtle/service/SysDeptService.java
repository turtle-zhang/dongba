package com.turtle.service;

import java.util.List;
import java.util.Map;

/**
 * 部门的业务处理层
 * @author Administrator
 *
 */
public interface SysDeptService {
	
	/**
	 * 查询出来我们的部门信息
	 * @return
	 */
	List<Map<String,Object>> findObjects();
}
