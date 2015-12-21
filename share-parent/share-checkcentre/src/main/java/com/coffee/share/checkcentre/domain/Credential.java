package com.coffee.share.checkcentre.domain;

/**
 * 提交的参数的一个模型工具
 * 
 * @author and04
 *
 */
public abstract class Credential {

	/**
	 * 错误信息
	 */
	private String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * 根据名字获取参数
	 * 
	 * @param name
	 * @return
	 */
	public abstract String getParamter(String name);

	/**
	 * 根据名字获取参数数据
	 * 
	 * @param name
	 * @return
	 */
	public abstract String[] getParamters(String name);
	
	/**
	 * 从session中获取验证码
	 * @return
	 */
	public abstract String getCaptchaCodeFromSession();
}
