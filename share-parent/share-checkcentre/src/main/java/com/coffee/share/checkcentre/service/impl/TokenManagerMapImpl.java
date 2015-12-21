package com.coffee.share.checkcentre.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;
import javax.inject.Named;

import com.coffee.share.checkcentre.domain.Loginer;
import com.coffee.share.checkcentre.domain.Token;
import com.coffee.share.checkcentre.service.TokenManagerService;
import com.coffee.share.checkcentre.util.Configuration;

/**
 * 
 * @author and04
 *
 */
@Named
public class TokenManagerMapImpl implements TokenManagerService {

	private static final Map<String, Token> LOGIN_MAP = new ConcurrentHashMap<>();

	@Inject
	private Configuration config;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.coffee.share.checkcentre.service.TokenManagerService#validata(java.
	 * lang.String)
	 */
	@Override
	public Loginer validata(String vt) {
		Token token = LOGIN_MAP.get(vt);
		return token == null ? null : token.getLoginer();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.coffee.share.checkcentre.service.TokenManagerService#addToken(java.
	 * lang.String, com.coffee.share.checkcentre.domain.Loginer)
	 */
	@Override
	public void addToken(String vt, Loginer loginer) {
		Token t = new Token();
		t.setLoginer(loginer);
		t.setExpired(System.currentTimeMillis() + config.getTokenTimeout() * 60 * 1000);
		LOGIN_MAP.put(vt, t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.coffee.share.checkcentre.service.TokenManagerService#invalid(java.
	 * lang.String)
	 */
	@Override
	public void invalid(String vt) {
		if (vt != null) {
			LOGIN_MAP.remove(vt);
		}
	}

}
