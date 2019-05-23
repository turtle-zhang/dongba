package com.turtle.common.exception;

/**
 * 这个是对菜单模块的service层的异常封装
 * @author Administrator
 *
 */
public class UserServiceException extends RuntimeException {

	private static final long serialVersionUID = 8182225946591545973L;

	public UserServiceException() {
		super();
	}

	public UserServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserServiceException(String message) {
		super(message);
	}

	public UserServiceException(Throwable cause) {
		super(cause);
	}
	
	
}
