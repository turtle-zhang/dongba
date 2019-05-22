package com.turtle.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.turtle.common.exception.MenuServiceException;
import com.turtle.dao.SysMenuDao;
import com.turtle.dao.SysRoleMenuDao;
import com.turtle.entity.SysMenu;
import com.turtle.service.SysMenuService;
import com.turtle.vo.Node;


@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;

	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;

	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> findObjects = sysMenuDao.findObjects();
		if(findObjects == null || findObjects.size() <= 0) {
			throw new MenuServiceException("对不起，我们查询出来的数据有问题。");
		}
		return findObjects;
	}

	@Override
	public int deleteObject(Integer id) {

		if(id == null || id <= 0) {			
			throw new MenuServiceException("对不起，菜单删除时要传入正确的ID信息");
		}
		int childCount = sysMenuDao.getChildCount(id);
		if(childCount > 0) {
			throw new MenuServiceException("对不起，该菜单有子菜单数据，不允许删除");
		}

		// 这两个要加事务控制的
		int deleteObject_rows = sysMenuDao.deleteObject(id);
		if(deleteObject_rows <= 0) {
			throw new MenuServiceException("对不起，删除失败，该数据可能不存在了");
		}
		int deleteObjectsByMenuId_rows = sysRoleMenuDao.deleteObjectsByMenuId(id);
		if(deleteObjectsByMenuId_rows <= 0) {
			throw new MenuServiceException("对不起，在删除角色-菜单关系表的时候失败");
		}		
		return deleteObject_rows;
	}

	@Override
	public List<Node> findZtreeMenuNodes() {
		return sysMenuDao.findZtreeMenuNodes();
	}

	
	@Override
	public int saveObject(SysMenu sysMenu) {
		if(sysMenu == null) {
			throw new MenuServiceException("对不起，你没有填数据，我们无法为你进行写入");
		}
		if(StringUtils.isEmpty(sysMenu.getName()))
			throw new MenuServiceException("菜单名不能为空");

		//TODO ......这个是要对立面的每个属性都要进行验证的，但是这里是属于跳过了。。。
		int rows = 0;
		try {
			rows = sysMenuDao.insertObject(sysMenu);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MenuServiceException("保存失败");
		}
		return rows;
	}

	@Override
	public int updateObject(SysMenu sysMenu) {
		if(sysMenu == null) {
			throw new MenuServiceException("对不起，更新的数据不能为空");
		}
		// TODO ......这个是要对立面的每个属性都要进行验证的，但是这里是属于跳过了。。。
		int rows = 0;
		try {
			rows = sysMenuDao.updateObject(sysMenu);	
		}catch(Exception e) {
			e.printStackTrace();
			throw new MenuServiceException("更新失败");
		}
		if(rows <= 0) {
			throw new MenuServiceException("当前记录可能不存在了");
		}
		return rows;
	}



}
