package com.coffee.share.checkcentre.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffee.share.checkcentre.domain.Credential;
import com.coffee.share.checkcentre.domain.Loginer;
import com.coffee.share.checkcentre.exception.NoConfigException;
import com.coffee.share.checkcentre.service.AuthenticationHandler;
import com.coffee.share.checkcentre.service.PreLoginHandler;
import com.coffee.share.checkcentre.service.TokenManagerService;
import com.coffee.share.checkcentre.util.Configuration;
import com.coffee.share.common.utils.LoginCheckConstant;
import com.coffee.share.common.utils.CookieUtil;
import com.coffee.share.common.utils.UuidUitl;

/**
 * 登陆处理类
 * 
 * @author and04
 *
 */
@Controller
public class LoginController {

	@Inject
	private Configuration config;

	@Inject
	private TokenManagerService tokenManager;

	/**
	 * 登陆前的处理
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/prelogin", method = RequestMethod.GET)
	public Object preLogin(HttpSession session) throws Exception {
		PreLoginHandler preLoginHandler = config.getPreLoginHandler();
		if (preLoginHandler == null) {
			throw new NoConfigException("Not config preLoginHandler implement");
		}
		return preLoginHandler.handler(session);
	}

	/**
	 * 登陆请求
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest req, HttpServletResponse resp, String backUrl, Model model) {

		String loginViewName = config.getLoginViewName();

		String vt = CookieUtil.getCookie(LoginCheckConstant.VT, req); // 验证凭证

		if (vt == null) {
			String lt = CookieUtil.getCookie(LoginCheckConstant.LT, req); // 自动登陆凭证
			if (lt == null) {
				return getViewName(loginViewName);
			} else {
				// TODO 自动登陆凭证存在
			}
		} else {
			Loginer loginer = tokenManager.validata(vt); // vt存在时验证
			if (loginer != null) {
				// TODO 验证成功
			} else {
				return getViewName(loginViewName);
			}
		}
		return null;
	}

	/**
	 * 登陆处理
	 * 
	 * @param req
	 *            请求
	 * @param resp
	 *            响应
	 * @param backUrl
	 *            回调地址
	 * @param remember
	 *            是否记住我
	 * @return 页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String backUrl,
			boolean remember, Model model) {

		final Map<String, String[]> paramMap = req.getParameterMap();
		final String captchaCode = (String) session.getAttribute(PreLoginHandler.SESSION_ATTR_NAME);
		/**
		 * 创建参数凭证
		 */
		Credential credential = new Credential() {

			@Override
			public String[] getParamters(String name) {
				return paramMap.get(name);
			}

			@Override
			public String getParamter(String name) {
				String[] values = getParamters(name);
				return values != null && values.length > 0 ? values[0] : null;
			}

			@Override
			public String getCaptchaCodeFromSession() {
				return captchaCode;
			}
		};
		AuthenticationHandler authenticationHandler = config.getAuthenticationHandler();
		if (authenticationHandler == null) {
			throw new NoConfigException("Not config authenticationHandler implement");
		}
		Loginer loginer = authenticationHandler.authenticate(credential);

		if (loginer == null) {
			model.addAttribute("error", credential.getErrorMsg());
			String loginViewName = config.getLoginViewName();
			return getViewName(loginViewName);
		} else {
			tokenManager.addToken(UuidUitl.uuid(), loginer);

			// TODO 登陆成功；
			return null;
		}
	}

	/**
	 * 推出
	 * 
	 * @param backUrl
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(String backUrl, HttpServletRequest req, HttpServletResponse resp) {

		String vt = CookieUtil.getCookie(LoginCheckConstant.VT, req);
		tokenManager.validata(vt); // 移除令牌

		// 删除cookie
		Cookie cookie = new Cookie(LoginCheckConstant.VT, null);
		cookie.setMaxAge(0);
		resp.addCookie(cookie);

		// 通知所有的客户端推出
//		List<ClientSystem> clientSystems = config.getClientSystems();
//		for (ClientSystem clientSystem : clientSystems) {
////			clientSystem.noticeLogout(vt);  //TODO 待实现
//			//TODO 通知所有的客户端
//		}
		if (backUrl == null) {
			return "/logout";
		}
		return "redirect:" + backUrl;
	}

	/**
	 * 返回视图名字的处理
	 * 
	 * @param loginViewName
	 * @return
	 */
	private String getViewName(String loginViewName) {
		if (loginViewName == null) {
			throw new NoConfigException("Not config ViewName implement");
		}
		return loginViewName;
	}
}
