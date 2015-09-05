package com.luohj.privileges.core.exception;

/**
 * 功能说明:
 *
 * @author luohj
 * 
 * @Date 2015-9-5 上午11:17:03
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class BusiRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4848651636718191626L;

	public BusiRuntimeException() {
		super();
	}

	public BusiRuntimeException(String msg) {
		super(msg);
	}

	public BusiRuntimeException(String code, String msg) {
		super(code + ":" + msg);
	}

	public BusiRuntimeException(String code, String msg, Throwable cause) {
		super(code + ":" + msg, cause);
	}
	
	public BusiRuntimeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BusiRuntimeException(Throwable cause) {
		super(cause);
	}
}
