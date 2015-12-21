package com.coffee.share.checkcentre.dao;

import com.coffee.share.checkcentre.domain.LoginerUser;

/**
 * 
 * @author and04
 *
 */
public interface LoginerUserDao {

	/**
	 * 获取登陆人根据username
	 * 
	 * @param username
	 * @return
	 */
	LoginerUser getByUsername(String username);
}
