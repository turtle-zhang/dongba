package com.turtle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.turtle.entity.SysRole;
import com.turtle.vo.SysRoleMenuVo;

/**
 * 这个是对角色的数据持久层的操作
 * @author Administrator
 *
 */
public interface SysRoleDao {

	/**
	 * 这个是通过制定条件，查询返回分页后的数据
	 * @param username
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<SysRole> findPageObjects(@Param("name") String name, @Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);

	/**
	 * 通过名字去模糊查询我们的记录数
	 * @param username
	 * @return
	 */
	int getRowCount(@Param("name") String name);
	
	/**
	 * 通过id来删除角色信息
	 * @param id
	 * @return
	 */
	int deleteObject(@Param("id") Integer id);
	
	/**
	 * 添加角色信息
	 * @param sysRole
	 * @return
	 */
	int insertObject(SysRole sysRole);
	
	/**
	 * 通过角色id来得到这个角色身上的信息【要显示在编辑界面上的数据】
	 * @param id
	 * @return
	 */
	SysRoleMenuVo findObjectById(Integer id);
	
	/**
	 * 更新角色信息
	 * @return
	 */
	int updateObject(SysRole sysRole);
}




























