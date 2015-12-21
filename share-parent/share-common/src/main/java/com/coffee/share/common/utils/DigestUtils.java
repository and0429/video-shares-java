package com.coffee.share.common.utils;

import org.springframework.util.Base64Utils;

/**
 * 
 * @author and04
 *
 */
public class DigestUtils {

	/**
	 * 字符串转换成Md5的16进制字符串
	 * 
	 * @param source
	 *            源字符串
	 * @return md5后的之值
	 */
	public static String md5AsHex(String source) {
		return org.springframework.util.DigestUtils.md5DigestAsHex(source.getBytes());
	}

	/**
	 * base64编码
	 * 
	 * @param src
	 *            字节数组
	 * @return 十六进制字符串
	 */
	public static String base64AsHex(byte[] src) {
		return Base64Utils.encodeToString(src);
	}
}
