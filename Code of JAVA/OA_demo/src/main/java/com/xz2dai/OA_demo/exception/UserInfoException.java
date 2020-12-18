package com.xz2dai.OA_demo.exception;

/**
 * 自定义异常信息
 *
 * @author yq
 * @date 2020年12月15日
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
