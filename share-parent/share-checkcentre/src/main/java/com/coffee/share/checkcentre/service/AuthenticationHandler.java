package com.coffee.share.checkcentre.service;

import com.coffee.share.checkcentre.domain.Credential;
import com.coffee.share.checkcentre.domain.Loginer;

/**
 * 验证鉴权处理接口
 * 
 * @author and04
 *
 */
public interface AuthenticationHandler {

	/**
	 * 鉴权
	 * 
	 * @param credential
	 * @return
	 */
	Loginer authenticate(Credential credential);
}
