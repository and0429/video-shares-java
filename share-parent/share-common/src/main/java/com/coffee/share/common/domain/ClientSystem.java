package com.coffee.share.common.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * 客户端系统对象
 * 
 * @author and04
 *
 */
public class ClientSystem {

	/**
	 * 唯一标识
	 */
	private String id;

	/**
	 * 客户端名称
	 */
	private String name;

	/**
	 * 应用的基础路径
	 */
	private String baseUrl;

	/**
	 * 应用的主页面
	 */
	private String homeUri;

	/**
	 * 内部通讯地址
	 */
	private String innerAddr;

	/**
	 * 主页地址
	 * 
	 * @return
	 */
	public String getHomeUrl() {
		return baseUrl + homeUri;
	}

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "baseUrl")
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	@XmlElement(name = "homeUri")
	public String getHomeUri() {
		return homeUri;
	}

	public void setHomeUri(String homeUri) {
		this.homeUri = homeUri;
	}

	@XmlElement(name = "innerAddr")
	public String getInnerAddr() {
		return innerAddr;
	}

	public void setInnerAddr(String innerAddr) {
		this.innerAddr = innerAddr;
	}
}
