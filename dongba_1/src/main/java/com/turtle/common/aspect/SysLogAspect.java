package com.turtle.common.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.dao.SysLogDao;


/**
 * 这个是对业务层的日志扩展功能
 * @author Administrator
 *
 */
@Service
@Aspect
public class SysLogAspect {

	@Autowired
	private SysLogDao sysLogDao;
	
	@Pointcut("bean(sysUserServiceImpl)")
	public void doLog() {
		
	}
	
	
	
	
}
