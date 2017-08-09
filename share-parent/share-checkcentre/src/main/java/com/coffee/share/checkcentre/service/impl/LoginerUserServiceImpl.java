package com.coffee.share.checkcentre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.share.checkcentre.dao.LoginerUserDao;
import com.coffee.share.checkcentre.domain.LoginerUser;
import com.coffee.share.checkcentre.service.LoginerUserService;

/**
 * 
 * @author and04
 *
 */
@Service
public class LoginerUserServiceImpl implements LoginerUserService {

	@Autowired
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
