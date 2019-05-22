package com.turtle.common.exception;

/**
 * 这个是对菜单模块的service层的异常封装
 * @author Administrator
 *
 */
public class MenuServiceException extends RuntimeException {

	private static final long serialVersionUID = 8182225946591545973L;

	public MenuServiceException() {
		super();
	}

	public MenuServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MenuServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public MenuServiceException(String message) {
		super(message);
	}

	public MenuServiceException(Throwable cause) {
		super(cause);
	}
	
	
}
