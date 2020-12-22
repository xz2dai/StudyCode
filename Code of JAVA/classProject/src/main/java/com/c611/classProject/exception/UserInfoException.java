package com.c611.classProject.exception;

/**
 * 自定义异常信息
 * 
 * @author Gordon
 * @date 2020年12月15日下午5:17:12
 * @version v12.12
 */
public class UserInfoException extends Exception {

	private static final long serialVersionUID = 2242846698480186684L;

	public UserInfoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserInfoException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserInfoException(String message) {
		super(message);
	}

	public UserInfoException(Throwable cause) {
		super(cause);
	}

}
