package com.turtle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.common.SystemData;
import com.turtle.common.exception.RoleServiceException;
import com.turtle.dao.SysRoleDao;
import com.turtle.dao.SysRoleMenuDao;
import com.turtle.dao.SysUserRoleDao;
import com.turtle.entity.SysRole;
import com.turtle.service.SysRoleService;
import com.turtle.vo.PageObject;
import com.turtle.vo.SysRoleMenuVo;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Override
	public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
		
		if(pageCurrent == null || pageCurrent <= 0) {
			throw new RoleServiceException("查询角色的页码值友问题哦");
		}
		int rowCount = sysRoleDao.getRowCount(name);
		if(rowCount <= 0) {
			throw new RoleServiceException("对不起，服务器没有找到数据");
		}
		Integer startIndex = (pageCurrent - 1)*SystemData.PAGE_SIZE;
		Integer pageCount = (rowCount - 1)/ SystemData.PAGE_SIZE + 1;
		List<SysRole> findPageObjects = sysRoleDao.findPageObjects(name, startIndex, SystemData.PAGE_SIZE);
				
		PageObject<SysRole> pageObject = new PageObject<SysRole>();
		pageObject.setPageCount(pageCount);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(SystemData.PAGE_SIZE);
		pageObject.setRecords(findPageObjects);
		pageObject.setRowCount(rowCount);

		return pageObject;
	}

	@Override
	public int deleteObject(Integer id) {
		if(id == null || id <= 0) {
			throw new RoleServiceException("请至少选择一个进行删除");
		}
		int row = sysRoleDao.deleteObject(id);
		if(row <= 0) {
			throw new RoleServiceException("对不起，删除的记录可能不存在");
		}		
		sysRoleMenuDao.deleteObjectsByRoleId(id);
		sysUserRoleDao.deleteObjectsByRoleId(id);		
		return row;
	}

	@Override
	public int saveObject(SysRole entity, Integer[] menuIds) {
		if(entity == null) {
			throw new RoleServiceException("要添加的对象不能为空的");
		}
		//TODO 详细内容就不写了
		if(menuIds == null || menuIds.length <= 0) {
			throw new RoleServiceException("必须要给角色赋予权限的");
		}
		int rows = sysRoleDao.insertObject(entity);
		sysRoleMenuDao.insertObjects(entity.getId(), menuIds);
		
		return rows;
	}

	@Override
	public SysRoleMenuVo findObjectById(Integer id) {
		if(id == null || id <= 0) {
			throw new RoleServiceException("对不起，请选择记录再进行编辑");
		}
		SysRoleMenuVo findObjectById = sysRoleDao.findObjectById(id);
		if(findObjectById == null) {
			throw new RoleServiceException("记录有问题，可能不存在了");
		}	
		return findObjectById;
	}

	@Override
	public int updateObject(SysRole entity, Integer[] menuIds) {
		
		if(entity == null) {
			throw new RoleServiceException("更新的角色信息不能为空的");
		}
		//TODO 可以选择对里面的额详细属性来进行监控判断
		if(menuIds == null || menuIds.length <= 0) {
			throw new RoleServiceException("请至少为角色赋予一种权限");
		}
		int rows = sysRoleDao.updateObject(entity);
		if(rows <= 0) {
			throw new RoleServiceException("对不起，该记录可能已经不存在了");
		}
		//先将关系表中的数据删除，然后再重新写入
		sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
		sysRoleMenuDao.insertObjects(entity.getId(), menuIds);

		return rows;
	}
	
	

}






















