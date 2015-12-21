package com.coffee.share.checkcentre.service;

import com.coffee.share.checkcentre.domain.Loginer;

/**
 * 令牌管理的业务接口
 * 
 * @author and04
 *
 */
public interface TokenManagerService {

	/**
	 * 验证vt
	 * 
	 * @param vt
	 * @return
	 */
	Loginer validata(String vt);

	/**
	 * 添加令牌
	 * 
	 * @param vt
	 * @param loginer
	 */
	void addToken(String vt, Loginer loginer);

	/**
	 * 令牌失效
	 * 
	 * @param vt
	 */
	void invalid(String vt);
}
