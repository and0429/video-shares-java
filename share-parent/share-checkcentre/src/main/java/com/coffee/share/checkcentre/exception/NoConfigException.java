package com.coffee.share.checkcentre.exception;

/**
 * 没有配置异常
 * 
 * @author and04
 *
 */
public class NoConfigException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2212080696317951545L;

	public NoConfigException() {
		super();
	}

	public NoConfigException(String reason) {
		super(reason);
	}
}
