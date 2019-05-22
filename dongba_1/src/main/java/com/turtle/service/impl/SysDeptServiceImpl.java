package com.turtle.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.common.exception.DeptServiceException;
import com.turtle.dao.SysDeptDao;
import com.turtle.service.SysDeptService;

@Service
public class SysDeptServiceImpl implements SysDeptService {

	@Autowired
	private SysDeptDao sysDeptDao;
	
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> findObjects = sysDeptDao.findObjects();
		if(findObjects == null || findObjects.size() <= 0) {
			throw new DeptServiceException("对不起，服务器中没有找到数据了");
		}
		return findObjects;
	}

	
}
