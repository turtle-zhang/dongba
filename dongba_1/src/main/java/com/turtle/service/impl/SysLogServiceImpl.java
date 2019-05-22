package com.turtle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.vo.PageObject;
import com.turtle.common.SystemData;
import com.turtle.common.exception.LogServiceException;
import com.turtle.dao.SysLogDao;
import com.turtle.entity.SysLog;
import com.turtle.service.SysLogService;

/**
 * 这个是对于日志操作的业务处理层
 * @author Administrator
 *
 */
@Service
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {

//		1)	通过参数变量接收控制层数据(例如username,pageCurrent)
//		2)	对数据进行合法验证(例如pageCurrent不能小于1)
//		3)	基于参数数据进行总记录数查询(通过此结果要计算总页数)
//		4)	基于参数数据进行当前页记录的查询(username,startIndex,pageSize)
//		5)	对数据进行封装(例如封装分页信息和当前页记录)
//		6)	..........
		
		if(pageCurrent == null || pageCurrent <= 0) {
			throw new LogServiceException("日志层：传过来的页码值不能为空或为小于0的数");
		}		
		int rowCount = sysLogDao.getRowCount(username);
		if(rowCount <= 0) {
			throw new LogServiceException("目前日志记录为空");
		}
		Integer startIndex = (pageCurrent - 1) * SystemData.PAGE_SIZE;
		Integer pageCount = (rowCount - 1) / SystemData.PAGE_SIZE + 1;
		List<SysLog> findPageObjects = sysLogDao.findPageObjects(username, SystemData.PAGE_SIZE, startIndex);
		
		PageObject pageObject = new PageObject();		
		pageObject.setPageSize(SystemData.PAGE_SIZE);
		pageObject.setPageCount(pageCount);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(findPageObjects);
		
		return pageObject;
	}

	@Override
	public int deleteObjects(Integer... ids) {
		if(ids == null || ids.length < 1) {
			throw new LogServiceException("对不起，你穿的删除日志ID不能为空的");
		}
		int delete_rows = 0;
		try {
			delete_rows = sysLogDao.deleteObjects(ids);	
		}catch(Exception e) {
			e.printStackTrace();
			throw new LogServiceException("删除数据时，系统出现异常了");
		}
		if(delete_rows == 0) {
			throw new LogServiceException("对不起，可能数据已经不存在了");
		}
		return delete_rows;
	}

}

























