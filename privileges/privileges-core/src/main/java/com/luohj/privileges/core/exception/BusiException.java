package com.luohj.privileges.core.exception;

/**
 * 功能说明:
 *
 * @author luohj
 * 
 * @Date 2015-9-5 上午11:20:56
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class BusiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4848651636718191626L;
	public BusiException() {
		super();
	}

	public BusiException(String msg) {
		super(msg);
	}

	public BusiException(String code, String msg) {
		super(code + ":" +msg);
	}

	public BusiException(String code, String msg, Throwable cause) {
		super(code + ":" +msg, cause);
	}
	
	public BusiException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BusiException(Throwable cause) {
		super(cause);
	}
}
