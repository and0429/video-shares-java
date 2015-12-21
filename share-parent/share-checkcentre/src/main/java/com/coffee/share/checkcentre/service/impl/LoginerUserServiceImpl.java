package com.coffee.share.checkcentre.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.coffee.share.checkcentre.dao.LoginerUserDao;
import com.coffee.share.checkcentre.domain.LoginerUser;
import com.coffee.share.checkcentre.service.LoginerUserService;

/**
 * 
 * @author and04
 *
 */
@Named
public class LoginerUserServiceImpl implements LoginerUserService {

	@Inject
	private LoginerUserDao dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.coffee.share.service.LoginerService#getByUsername(java.lang.String)
	 */
	@Override
	public LoginerUser getByUsername(String username) {
		return dao.getByUsername(username);
	}

}
