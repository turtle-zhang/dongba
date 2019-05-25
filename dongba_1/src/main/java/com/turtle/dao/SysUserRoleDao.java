package com.turtle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysUserRoleDao {
	
	/**
	 * 通过角色id来删除角色-用户的关系
	 * @param roleId
	 * @return
	 */
	int deleteObjectsByRoleId(@Param("roleId")Integer roleId);
	
	/**
	 * 将用户-角色对应的关系写到关系表中
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	int insertObjects(@Param("userId")Integer userId,@Param("roleIds")Integer[]roleIds);
	
	
	/**
	 * 通过用户id来查询角色对应的id信息
	 * @param id
	 * @return
	 */
	List<Integer> findRoleIdsByUserId(Integer id);
	
	/**
	 * 通过用户ID来删除用户-角色的对应关系表
	 * @param userId
	 * @return
	 */
	int deleteObjectsByUserId(Integer userId);
}
