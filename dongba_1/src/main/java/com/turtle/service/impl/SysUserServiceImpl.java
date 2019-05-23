package com.turtle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.common.SystemData;
import com.turtle.common.exception.UserServiceException;
import com.turtle.dao.SysUserDao;
import com.turtle.service.SysUserService;
import com.turtle.vo.PageObject;
import com.turtle.vo.SysUserDeptVo;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

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

}
