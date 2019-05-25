package com.turtle.service;

import java.util.Map;

import com.turtle.entity.SysUser;
import com.turtle.vo.PageObject;
import com.turtle.vo.SysUserDeptVo;

/**
 * 这个是对用户进行处理的业务层
 * @author Administrator
 *
 */
public interface SysUserService {
	
	/**
	 * 通过分页查询出我们要的数据
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	PageObject<SysUserDeptVo> findPageObjects(String username, Integer pageCurrent);
	
	/**
	 * 对用户的权限进行修改
	 * @param id
	 * @param valid
	 * @param modifiedUser
	 * @return
	 */
	int validById(Integer id, Integer valid, String modifiedUser);

	/**
	 * 保存用户信息
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int saveObject(SysUser entity, Integer[] roleIds);
	
	/**
	 * 将要显示在编辑界面的数据返回出来
	 * @param userId
	 * @return
	 */
	Map<String, Object> findObjectById(Integer userId);
	
	/**
	 * 对用户信息进行更新操作
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int updateObject(SysUser entity,Integer[] roleIds);
	
	/**
	 * 更新用户的密码的操作
	 * @param password
	 * @param newPassword
	 * @param cfgPassword
	 * @return
	 */
	int updatePassword(String password,String newPassword,String cfgPassword);

}
