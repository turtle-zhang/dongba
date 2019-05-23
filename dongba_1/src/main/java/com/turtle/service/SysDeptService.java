package com.turtle.service;

import java.util.List;
import java.util.Map;

import com.turtle.entity.SysDept;
import com.turtle.vo.Node;

/**
 * 部门的业务处理层
 * @author Administrator
 *
 */
public interface SysDeptService {

	/**
	 * 查询出来我们的部门信息
	 * @return
	 */
	List<Map<String,Object>> findObjects();

	/**
	 * 通过部门id来删除部门对应的信息
	 * 
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);

	/**
	 * 返回查询出来的部门上下级关系
	 * @return
	 */
	List<Node> doFindZtreeDeptNodes();
	
	/**
	 * 将部门信息插入部门表中
	 * @param entity
	 * @return
	 */
	int saveObject(SysDept entity);
	
	/**
	 * 对部门信息做更新操作
	 * @param enetity
	 * @return
	 */
	int updateObject(SysDept entity);
}
