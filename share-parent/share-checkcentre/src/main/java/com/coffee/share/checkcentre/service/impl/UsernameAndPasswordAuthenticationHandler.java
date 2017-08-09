package com.coffee.share.checkcentre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import com.coffee.share.checkcentre.domain.Credential;
import com.coffee.share.checkcentre.domain.Loginer;
import com.coffee.share.checkcentre.domain.LoginerUser;
import com.coffee.share.checkcentre.service.AuthenticationHandler;
import com.coffee.share.checkcentre.service.LoginerUserService;

/**
 * 用户名密码鉴权
 * 
 * @author and04
 *
 */
public class UsernameAndPasswordAuthenticationHandler implements AuthenticationHandler {

	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";

	private static final String NO_USERNAME = "No username";
	private static final String ERROR_PASSWORD = "Error password";
	private static final String NO_USERNAME_OR_PASSWORD = "No username or password";
	private static final String CAPTCHA_ERROR = "captcha error";

	private static final String CAPTCHA = "captcha";

	@Autowired
	private LoginerUserService loginerUserService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.coffee.share.checkcentre.service.AuthenticationHandler#authenticate(
	 * com.coffee.share.checkcentre.domain.Credential)
	 */
	@Override
	public Loginer authenticate(Credential credential) {

		String captcha = credential.getParamter(CAPTCHA);
		String captchaFromSession = credential.getCaptchaCodeFromSession();

		if (!captcha.equals(captchaFromSession)) {
			credential.setErrorMsg(CAPTCHA_ERROR);
			return null;
		}
		String username = credential.getParamter(USERNAME);
		String password = credential.getParamter(PASSWORD);

		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			credential.setErrorMsg(NO_USERNAME_OR_PASSWORD);
			return null;
		}

		password = DigestUtils.md5DigestAsHex(password.getBytes());
		LoginerUser loginer = loginerUserService.getByUsername(username);
		if (loginer == null) {
			credential.setErrorMsg(NO_USERNAME);
			return null;
		}
		if (!password.equals(loginer.getPassword())) {
			credential.setErrorMsg(ERROR_PASSWORD);
			return null;
		}
		return loginer;
	}
}
