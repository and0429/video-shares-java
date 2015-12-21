package com.coffee.share.common.utils;

import java.util.UUID;

import org.springframework.util.StringUtils;

/**
 * 
 * @author and04
 *
 */
public class UuidUitl {

	/**
	 * 生成不带“-”的UUID
	 * 
	 * @return
	 */
	public static String uuid() {
		String uuid = UUID.randomUUID().toString();
		return StringUtils.delete(uuid, "-");
	}
}
