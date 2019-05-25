package com.turtle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.turtle.entity.SysUser;
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

	/**
	 * 将用户信息保存到用户表中
	 * @param entity
	 * @return
	 */
	int insertObject(SysUser entity);

	/**
	 * 通过用户Id来查询用户-部门信息
	 * @param id
	 * @return
	 */
	SysUserDeptVo findObjectById(Integer id);

	/**
	 * 对用户进行更新操作
	 * @param entity
	 * @return
	 */
	int updateObject(SysUser entity);

	/**
	 * 修改密码，更新用户表中的密码、盐值
	 * @param password
	 * @param salt
	 * @param id
	 * @return
	 */
	int updatePassword(@Param("password")String password,@Param("salt")String salt,@Param("id")Integer id);
	
	/**
	 * 通过用户名来得到用户信息
	 * @param username
	 * @return
	 */
	SysUser findUserByUserName(String username);

}

















