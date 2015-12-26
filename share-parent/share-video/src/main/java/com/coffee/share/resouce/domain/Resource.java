package com.coffee.share.resouce.domain;

/**
 * 资源
 * 
 * @author and04
 *
 */
public class Resource {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 资源的类型
	 */
	private String type;

	/**
	 * 名字
	 */
	private String name;

	/**
	 * 作者
	 */
	private String anthor;

	/**
	 * 地址
	 */
	private Address addr;

	/**
	 * 所属机构
	 */
	private String orgnization;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnthor() {
		return anthor;
	}

	public void setAnthor(String anthor) {
		this.anthor = anthor;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public String getOrgnization() {
		return orgnization;
	}

	public void setOrgnization(String orgnization) {
		this.orgnization = orgnization;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
