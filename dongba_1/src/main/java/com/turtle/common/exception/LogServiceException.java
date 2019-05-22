package com.turtle.common.exception;

/**
 * 这个是对日志模块的service层的异常封装
 * @author Administrator
 *
 */
public class LogServiceException extends RuntimeException {

	private static final long serialVersionUID = 7255203568503575855L;

	public LogServiceException() {
		super();
	}

	public LogServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LogServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public LogServiceException(String message) {
		super(message);
	}

	public LogServiceException(Throwable cause) {
		super(cause);
	}
	
	
}
