package com.coffee.share.system.controller.dto;

import com.coffee.share.system.utils.Pager;

public class DataDictionaryConditionDto extends Pager {

	/**
	 * 
	 */
	private String type;

	/**
	 * 
	 */
	private String key;

	/**
	 * 
	 */
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
