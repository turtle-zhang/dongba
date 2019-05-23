package com.turtle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 这个是 角色菜单 的关系表对应的操作
 * @author Administrator
 *
 */
public interface SysRoleMenuDao {
	
	/**
	 * 这个是通过菜单ID来删除菜单角色关系表中的记录【一个角色就有一个菜单对应】
	 * @param menuId
	 * @return
	 */
	int deleteObjectsByMenuId(Integer menuId);
	
	/**
	 * 通过角色id来删除角色-菜单的对应关系
	 * @param roleId
	 * @return
	 */
	int deleteObjectsByRoleId(@Param("roleId")Integer roleId);
	
	/**
	 * 通过角色id，菜单id，将其数据插入角色-菜单关系表中	
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
	int insertObjects(@Param("roleId")Integer roleId, @Param("menuIds")Integer[] menuIds);

	/**
	 * 通过角色id来查询菜单id的信息
	 * @param roleId
	 * @return
	 */
	List<Integer> findMenuIdsByRoleId(@Param("roleId")Integer roleId);
	              
}
