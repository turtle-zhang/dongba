package com.turtle.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.common.exception.DeptServiceException;
import com.turtle.dao.SysDeptDao;
import com.turtle.dao.SysUserDao;
import com.turtle.entity.SysDept;
import com.turtle.service.SysDeptService;
import com.turtle.vo.Node;

@Service
public class SysDeptServiceImpl implements SysDeptService {

	@Autowired
	private SysDeptDao sysDeptDao;
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> findObjects = sysDeptDao.findObjects();
		if(findObjects == null || findObjects.size() <= 0) {
			throw new DeptServiceException("对不起，服务器中没有找到数据了");
		}
		return findObjects;
	}

	@Override
	public int deleteObject(Integer id) {
		
		if(id == null || id <= 0) {
			throw new DeptServiceException("对不起，比用来删除的信息有问题");
		}
		int childDepts = sysDeptDao.getChildCount(id);
		if(childDepts >= 1) {
			throw new DeptServiceException("对不起，该部门有子部门，不允许删除");
		}
		int users = sysUserDao.getUserCountByDeptId(id);
		if(users >= 1) {
			throw new DeptServiceException("对不起，该部门中还有员工信息，不能删除");
		}
		int deleteDepts = 0;
		try {
			deleteDepts = sysDeptDao.deleteObject(id);
		}catch(Exception e) {
			e.printStackTrace();
			throw new DeptServiceException("服务器内部出现异常");
		}
		if(deleteDepts <= 0) {
			throw new DeptServiceException("该记录可能 不存在了");
		}
		return deleteDepts;
	}

	
	@Override
	public List<Node> doFindZtreeDeptNodes() {
		List<Node> findZtreeDeptNodes = sysDeptDao.findZtreeDeptNodes();
		if(findZtreeDeptNodes == null || findZtreeDeptNodes.size() <= 0) {
			throw new DeptServiceException("对不起，没有找到对应的节点信息");
		}
		return findZtreeDeptNodes;
	}

	@Override
	public int saveObject(SysDept entity) {
		if(entity == null) {
			throw new DeptServiceException("对不起，你传了空的数据过来");
		}
		//TODO ...... 再将详细信息进行验证
		int rows = 0;
		try {
			rows = sysDeptDao.insertObject(entity);
		}catch(Exception e) {
			e.printStackTrace();
			throw new DeptServiceException("服务器写入数据异常");
		}
		if(rows <= 0) {
			throw new DeptServiceException("没有写入");
		}
		return rows;
	}

	@Override
	public int updateObject(SysDept entity) {
		if(entity == null) {
			throw new DeptServiceException("用来更新的数据不能为空的");
		}
		int rows = sysDeptDao.updateObject(entity);
		if(rows <= 0) {
			throw new DeptServiceException("更新的记录可能不存在了");
		}
		return rows;
	}	
	
	
}
