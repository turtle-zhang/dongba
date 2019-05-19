package com.turtle.dao;

import org.apache.ibatis.annotations.Param;

public interface SysLogDao {
	
	/**
	 * 通过一个到多个id来删除日志表中的信息
	 * @param id
	 * @return
	 */
	public int deleteObjects(@Param("ids") Integer...id);
}
