package com.turtle.common.exception;

/**
 * 这个是对菜单模块的service层的异常封装
 * @author Administrator
 *
 */
public class RoleServiceException extends RuntimeException {

	private static final long serialVersionUID = 8182225946591545973L;

	public RoleServiceException() {
		super();
	}

	public RoleServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RoleServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public RoleServiceException(String message) {
		super(message);
	}

	public RoleServiceException(Throwable cause) {
		super(cause);
	}
	
	
}
