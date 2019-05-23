package com.turtle.dao;

import org.apache.ibatis.annotations.Param;

public interface SysUserRoleDao {
	
	/**
	 * 通过角色id来删除角色-用户的关系
	 * @param roleId
	 * @return
	 */
	int deleteObjectsByRoleId(@Param("roleId")Integer roleId);
}
