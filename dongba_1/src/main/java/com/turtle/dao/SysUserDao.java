package com.turtle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.turtle.vo.SysUserDeptVo;

/**
 * 对用户的一些操作业务
 * @author Administrator
 *
 */
public interface SysUserDao {

	/**
	 * 通过部门id来查询其部门是否有用户
	 * @param deptId
	 * @return
	 */
	int getUserCountByDeptId(@Param("deptId") Integer deptId);
	
	/**
	 * 通过分页查询出来我们要的信息
	 * @param naem
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<SysUserDeptVo> findPageObjects(@Param("username") String username, @Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);
	
	/**
	 * 通过用户名字来模糊查询记录数
	 * @param username
	 * @return
	 */
	int getRowCount(@Param("username") String username);
	
	/**
	 * 这个是修改用户的权限的
	 * @param id
	 * @param valid
	 * @param modifiedUser
	 * @return
	 */
	int validById(@Param("id")Integer id,@Param("valid")Integer valid,@Param("modifiedUser")String modifiedUser);

}
