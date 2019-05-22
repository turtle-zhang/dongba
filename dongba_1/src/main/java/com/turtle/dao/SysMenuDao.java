package com.turtle.dao;

import java.util.List;
import java.util.Map;

import com.turtle.entity.SysMenu;
import com.turtle.vo.Node;

/**
 * 主要是针对菜单层的一些持久化操作
 * @author Administrator
 *
 */
public interface SysMenuDao {

	/**
	 * 查询菜单信息，这里不采用对应类的方法，使用map集合的方法，当然只是练手，实际开发不适用，可读性太差了
	 * @return
	 */
	List<Map<String,Object>>findObjects();
	
	/**
	 * 通过id来查询菜单表中是否有子菜单记录
	 * @param id
	 * @return
	 */
	int getChildCount(Integer id);
	
	/**
	 * 通过id来删除菜单表中的数据
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * 将节点信息查询出来，包括外键
	 * @return
	 */
	List<Node> findZtreeMenuNodes();
	
	/**
	 * 往菜单表中添加数据
	 * @param entity
	 * @return
	 */
	int insertObject(SysMenu entity);
	
	/**
	 * 这个是对菜单信息进行更新
	 * @param entity
	 * @return
	 */
	int updateObject(SysMenu entity);
}






















