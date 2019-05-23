package com.turtle.dao;

import java.util.List;
import java.util.Map;

import com.turtle.entity.SysDept;
import com.turtle.vo.Node;

/**
 * 对部门的一些持久化操作
 * @author Administrator
 *
 */
public interface SysDeptDao {

	/**
	 * 将部门表中的信息查询出来，使用map来存放，没有使用对应的javabean类
	 * @return
	 */
	List<Map<String,Object> >findObjects();
	
	/**
	 * 通过部门id，来得出部门的详细信息
	 * @param id
	 * @return
	 */
	SysDept findById(Integer id);
	
	
	/**
	 * 通过部门id来查询其中有多少个子部门
	 * @param id
	 * @return
	 */
	int getChildCount(Integer id);
	
	/**
	 * 通过部门Id来删除部门记录信息
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * 查询出来部门表中的上下级菜单信息
	 * @return
	 */
	List<Node> findZtreeDeptNodes();
	
	/**
	 * 添加部门信息到部门表中
	 * @param entity
	 * @return
	 */
	int insertObject(SysDept entity);
	
	/**
	 * 对部门信息进行更新操作
	 * @param entity
	 * @return
	 */
	int updateObject(SysDept entity);
	
}
