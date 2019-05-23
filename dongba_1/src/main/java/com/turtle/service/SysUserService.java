package com.turtle.service;

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

}
