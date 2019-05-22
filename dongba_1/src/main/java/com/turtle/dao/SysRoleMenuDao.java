package com.turtle.dao;

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
}
