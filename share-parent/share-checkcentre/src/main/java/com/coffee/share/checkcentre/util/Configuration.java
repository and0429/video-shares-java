package com.coffee.share.checkcentre.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.XmlMappingException;

import com.coffee.share.checkcentre.service.AuthenticationHandler;
import com.coffee.share.checkcentre.service.PreLoginHandler;
import com.coffee.share.common.domain.ClientSystem;
import com.coffee.share.common.domain.ClientSystemList;
import com.coffee.share.common.spring.JaxbUtil;
import com.coffee.share.common.spring.ResourceUtil;

/**
 * 项目的基本配置信息
 * 
 * @author and04
 *
 */
public class Configuration {

    private static final Logger logger = LoggerFactory.getLogger(Configuration.class);

    @Autowired
    private JaxbUtil jaxbUtil;

    /**
     * 登陆视图名字
     */
    private String loginViewName;

    /**
     * 令牌的有效时间 （分钟）
     */
    private int tokenTimeout = 30;

    /**
     * 客户端列表集合
     */
    private List<ClientSystem> clientSystems;

    /**
     * 登陆前的预处理
     */
    private PreLoginHandler preLoginHandler;

    /**
     * 鉴权处理器
     */
    private AuthenticationHandler authenticationHandler;

    public AuthenticationHandler getAuthenticationHandler() {
        return authenticationHandler;
    }

    public void setAuthenticationHandler(AuthenticationHandler authenticationHandler) {
        this.authenticationHandler = authenticationHandler;
    }

    public String getLoginViewName() {
        return loginViewName;
    }

    public void setLoginViewName(String loginViewName) {
        this.loginViewName = loginViewName;
    }

    public int getTokenTimeout() {
        return tokenTimeout;
    }

    public void setTokenTimeout(int tokenTimeout) {
        this.tokenTimeout = tokenTimeout;
    }

    public PreLoginHandler getPreLoginHandler() {
        return preLoginHandler;
    }

    public void setPreLoginHandler(PreLoginHandler preLoginHandler) {
        this.preLoginHandler = preLoginHandler;
    }

    /**
     * 获取客户端集合
     * 
     * @return
     */
    public List<ClientSystem> getClientSystems() {
        return clientSystems;
    }

    /**
     * 刷新属性
     */
    public void refreshConfig() {
        try (InputStream is = ResourceUtil.getResourceAsStream("classpath:client_system.xml")) {
            ClientSystemList csl = jaxbUtil.unmarshaller(is, ClientSystemList.class);
            if (csl != null) {
                clientSystems = csl.getSystems();
            }
        } catch (XmlMappingException | IOException e) {
            logger.error("clientSystems get error", e);
        }
    }

    /**
     * 释放资源
     */
    public void destroy() {

    }
}
