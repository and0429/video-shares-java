package com.coffee.share.checkcentre.domain;

/**
 * 令牌模型
 * 
 * @author and04
 *
 */
public class Token {

	/**
	 * 登陆用户
	 */
	private Loginer loginer;

	/**
	 * 过期时间(时间戳)
	 */
	private long expired;

	public Loginer getLoginer() {
		return loginer;
	}

	public void setLoginer(Loginer loginer) {
		this.loginer = loginer;
	}

	public long getExpired() {
		return expired;
	}

	public void setExpired(long expired) {
		this.expired = expired;
	}
}
