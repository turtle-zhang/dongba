package com.turtle.service;

import com.turtle.entity.SysRole;
import com.turtle.vo.PageObject;
import com.turtle.vo.SysRoleMenuVo;

/**
 * 对角色的业务层的处理
 * @author Administrator
 *
 */
public interface SysRoleService {
	
	/**
	 * 查询角色信息出来
	 * @param name
	 * @param pageCurrent
	 * @return
	 */
	PageObject<SysRole> findPageObjects(String name, Integer pageCurrent);
	
	/**
	 * 通过id来删除角色表中的记录
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * 为角色表添加角色信息
	 * @param entity
	 * @param menuIds
	 * @return
	 */
	int saveObject(SysRole entity,Integer[] menuIds);
	
	/**
	 * 通过角色id，查询出来角色的信息
	 * @param id
	 * @return
	 */
	SysRoleMenuVo findObjectById(Integer id);
	
	/**
	 * 通过角色信息，选择的菜单信息，来修改角色记录和角色-菜单关系表中的记录
	 * @param entity
	 * @param menuIds
	 * @return
	 */
	int updateObject(SysRole entity,Integer[] menuIds);
}
