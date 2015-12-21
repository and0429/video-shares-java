package com.coffee.share.checkcentre.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * 登陆前的已处理接口（比如生成二维码）
 * 
 * @author and04
 *
 */
public interface PreLoginHandler {

	String SESSION_ATTR_NAME = "SESSION_ATTR_NAME"; // 验证码放到session的名字

	/**
	 * 预处理方法
	 * 
	 * @param session
	 * @return
	 */
	Map<?, ?> handler(HttpSession session) throws Exception;
}
