package com.turtle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.turtle.entity.SysLog;

/**
 * 映射文件为SysLogMapper.xml,主要是针对日志表的一些简单操作
 * @author Administrator
 *
 */
public interface SysLogDao {

	/**
	 * 通过一个到多个id来删除日志表中的信息
	 * @param id
	 * @return
	 */
	public int deleteObjects(@Param("ids") Integer...id);

	/**
	 * 通过模糊查询，模糊查询条件可以为空。来得到总记录数
	 * @param username
	 * @return
	 */
	public int getRowCount(@Param("username") String username);

	/**
	 * 通过模糊查询、然后进行将查询出来的数据分页返回
	 * @param username
	 * @param pageSize：页面大小
	 * @param startIndex：起始页
	 * @return
	 */
	public List<SysLog> findPageObjects(@Param("username") String username, 
										@Param("pageSize") Integer pageSize, 
										@Param("startIndex") Integer startIndex);
	
	/**
	 * 往日志表中插入日志信息
	 * @param entity
	 * @return
	 */
	public int insertObject(SysLog entity);
	
}
