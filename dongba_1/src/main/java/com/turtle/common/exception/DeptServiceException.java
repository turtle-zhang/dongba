package com.turtle.common.exception;

/**
 * 这个是对部门模块的service层的异常封装
 * @author Administrator
 *
 */
public class DeptServiceException extends RuntimeException {

	private static final long serialVersionUID = 8182225946591545973L;

	public DeptServiceException() {
		super();
	}

	public DeptServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DeptServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeptServiceException(String message) {
		super(message);
	}

	public DeptServiceException(Throwable cause) {
		super(cause);
	}
	
	
}
