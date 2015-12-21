package com.coffee.share.checkcentre.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.share.checkcentre.util.Configuration;

/**
 * 
 * @author and04
 *
 */
@RestController
@RequestMapping(value = "/config")
public class ConfigController {

	private static Logger logger = LoggerFactory.getLogger(ConfigController.class);
	
	private static final String SUCCESS = "success";
	private static final String FAILD = "faild";

	@Inject
	private Configuration config;

	/**
	 * 
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/refresh/{token}", method = RequestMethod.GET)
	public String refreshConfig(@PathVariable String token) {
		if ("admin".equals(token)) {
			config.refreshConfig();
			logger.info("======== refresh config sucess ========");
			return SUCCESS;
		}
		return FAILD;
	}
}
