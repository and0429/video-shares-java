package com.coffee.share.checkcentre.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import com.coffee.share.checkcentre.service.PreLoginHandler;
import com.coffee.share.checkcentre.util.ImgUtil;
import com.coffee.share.common.utils.DigestUtils;

/**
 * 验证码实现
 * 
 * @author and04
 *
 */
public class CaptchaPreLoginHandler implements PreLoginHandler {

	public static final String[] CODES = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	public static final int CODE_LENGTH = 4;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.coffee.share.checkcentre.service.PreLoginHandler#handler(javax.
	 * servlet.http.HttpSession)
	 */
	@Override
	public Map<?, ?> handler(HttpSession session) throws Exception {

		Map<String, Object> map = new HashMap<>();

		String randomCode = getRandomCode();
		session.setAttribute(PreLoginHandler.SESSION_ATTR_NAME, randomCode);
		byte[] imgByte = ImgUtil.getCaptchaImg(randomCode);
		String base64AsHexString = DigestUtils.base64AsHex(imgByte);
		map.put("imgData", "data:image/png;base64," + base64AsHexString);
		return map;
	}

	/**
	 * 产生随机码图片
	 * 
	 * @return
	 */
	private String getRandomCode() {

		Random r = new Random();
		StringBuffer buff = new StringBuffer();

		for (int i = 0; i < CODE_LENGTH; i++) {
			String code = CODES[r.nextInt(CODES.length)];
			buff.append(code);
		}
		return buff.toString();

	}

}
