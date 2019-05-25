package com.turtle.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.turtle.common.SystemData;
import com.turtle.common.exception.UserServiceException;
import com.turtle.dao.SysUserDao;
import com.turtle.dao.SysUserRoleDao;
import com.turtle.entity.SysUser;
import com.turtle.service.SysUserService;
import com.turtle.vo.PageObject;
import com.turtle.vo.SysUserDeptVo;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@Override
	public PageObject<SysUserDeptVo> findPageObjects(String username, Integer pageCurrent) {

		if(pageCurrent == null || pageCurrent <= 0) {
			throw new UserServiceException("传入的用户页码值有问题的哦");
		}
		int rowCount = sysUserDao.getRowCount(username);
		if(rowCount <= 0) {
			throw new UserServiceException("对不起，暂时没有找到数据哦");
		}
		Integer pageCount = (rowCount - 1) / SystemData.PAGE_SIZE + 1;
		Integer startIndex = (pageCurrent - 1) * SystemData.PAGE_SIZE + 1;
		List<SysUserDeptVo> findPageObjects = sysUserDao.findPageObjects(username, startIndex, SystemData.PAGE_SIZE);

		PageObject<SysUserDeptVo> pageObject = new PageObject<SysUserDeptVo>();
		pageObject.setPageCount(pageCount);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(SystemData.PAGE_SIZE);
		pageObject.setRecords(findPageObjects);
		pageObject.setRowCount(rowCount);

		return pageObject;
	}

	@Override
	public int validById(Integer id, Integer valid, String modifiedUser) {
		if(id == null || id <= 0) {
			throw new UserServiceException("被修改权限的id信息有误");
		}
		if(valid == null && valid != 1 && valid != 0) {
			throw new UserServiceException("修改了异常的权限，请不要执行异常操作。");
		}
		if(modifiedUser == null || modifiedUser == "") {
			throw new UserServiceException("必须让我知道是谁在修改权限信息");
		}
		int validById = 0;
		try{
			validById = sysUserDao.validById(id, valid, modifiedUser);
		}catch(Exception e) {
			// TODO 通知运维人员
			e.printStackTrace();
			throw new UserServiceException("系统底层正在维护中");
		}
		if(validById <= 0) {
			throw new UserServiceException("该记录可能已经不存在了");
		}
		return validById;
	}

	@Override
	public int saveObject(SysUser entity, Integer[] roleIds) {
		if(entity == null) {
			throw new UserServiceException("用户信息不能为空");
		}
		//TODO 这里应该是要对立面的详细内容进行规划的
		
		if(roleIds == null || roleIds.length <= 0) {
			throw new UserServiceException("必须为用户赋予权限");
		}
		
		// 对密码的写入要进行加密写入
		String salt = UUID.randomUUID().toString();
		entity.setSalt(salt);
		SimpleHash sHash = new SimpleHash("MD5", entity.getPassword(), salt);
		entity.setPassword(sHash.toHex());
		
		int rows = sysUserDao.insertObject(entity);
		if(rows <= 0) {
			throw new UserServiceException("对不起，数据写入失败");
		}
		sysUserRoleDao.insertObjects(entity.getId(), roleIds);
		
		return rows;
	}

	@Override
	public Map<String, Object> findObjectById(Integer userId) {
		if(userId == null || userId <= 0) {
			throw new UserServiceException("对不起，你的用户信息是有问题的");
		}
		SysUserDeptVo findObjectById = sysUserDao.findObjectById(userId);
		if(findObjectById == null) {
			throw new UserServiceException("对不起，该数据记录可能已经不存在了");
		}
		List<Integer> findRoleIdsByUserId = sysUserRoleDao.findRoleIdsByUserId(userId);
		if(findRoleIdsByUserId == null || findRoleIdsByUserId.size() <= 0) {
			throw new UserServiceException("对不起，该记录可能私有问题的");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", findObjectById);
		map.put("roleIds", findRoleIdsByUserId);
		
		return map;
	}

	@Override
	public int updateObject(SysUser entity, Integer[] roleIds) {
		if(entity == null) {
			throw new UserServiceException("对v不起，更新的数据有问题的");
		}
		if(roleIds == null || roleIds.length <= 0) {
			throw new UserServiceException("请务必为用户赋予角色");
		}
		int updateObject = sysUserDao.updateObject(entity);
		if(updateObject  <= 0) {
			throw new UserServiceException("数据更新失败，可能不存在当前数据了");
		}
		sysUserRoleDao.deleteObjectsByUserId(entity.getId());
		sysUserRoleDao.insertObjects(entity.getId(), roleIds);
		return updateObject;
	}

	@Override
	public int updatePassword(String password, String newPassword, String cfgPassword) {
		
		//1.判定新密码与密码确认是否相同
		if(StringUtils.isEmpty(newPassword))
		throw new IllegalArgumentException("新密码不能为空");
		
		if(StringUtils.isEmpty(cfgPassword))
		throw new IllegalArgumentException("确认密码不能为空");
		
		if(!newPassword.equals(cfgPassword))
		throw new IllegalArgumentException("两次输入的密码不相等");
		
		//2.判定原密码是否正确
		if(StringUtils.isEmpty(password))
		throw new IllegalArgumentException("原密码不能为空");
		
		// 获取登入用户，然后进行对应的操作
		SysUser principal = (SysUser)SecurityUtils.getSubject().getPrincipal();
		SimpleHash sHash = new SimpleHash("MD5",password,principal.getSalt(),1);
		if(principal.getPassword().equalsIgnoreCase(sHash.toHex()) == false) {
			throw new UserServiceException("对不起，你的原密码有问题哦");
		}		
		String salt = UUID.randomUUID().toString();
		SimpleHash sHash2 = new SimpleHash("MD5",newPassword,salt,1);
		
		// 更新数据
		int updatePassword = sysUserDao.updatePassword(sHash2.toHex(), salt, principal.getId());	
		if(updatePassword <= 0) {
			throw new UserServiceException("更新失败");
		}
		return updatePassword;
	}
	
	

}























