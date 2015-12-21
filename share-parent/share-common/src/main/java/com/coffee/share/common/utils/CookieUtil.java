package com.coffee.share.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * cookie操作工具类
 * 
 * @author and04
 *
 */
public class CookieUtil {

	/**
	 * 根据cookie名字获取cookie值
	 * 
	 * @param cookieName
	 *            cookie名字
	 * @param req
	 *            请求
	 * @return cookie值或者null;
	 */
	public static String getCookie(String cookieName, HttpServletRequest req) {

		String cookieValue = null;

		if (cookieName == null || req == null) {
			return null;
		}

		Cookie[] cookies = req.getCookies();

		if (cookies == null) {
			return null;
		}

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cookieName)) {
				cookieValue = cookie.getValue();
			}
		}
		return cookieValue;
	}
}
