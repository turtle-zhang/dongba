package com.turtle.dao;

import java.util.List;
import java.util.Map;

public interface SysDeptDao {

	/**
	 * 将部门表中的信息查询出来，使用map来存放，没有使用对应的javabean类
	 * @return
	 */
	List<Map<String,Object> >findObjects();
}
