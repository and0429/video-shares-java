package com.coffee.share.system.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.share.system.domain.DataDictionary;
import com.coffee.share.system.service.DataDictionaryService;

/**
 * 数据字典
 * 
 * @author and04
 *
 */
@RestController
@RequestMapping(value = "/datadictionary")
public class DataDictionaryController {

	@Inject
	private DataDictionaryService service;

	/**
	 * save
	 * @param dd
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void save(DataDictionary dd) {
		service.save(dd);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/values/{key}", method = RequestMethod.GET)
	public Object getValues(@PathVariable String key){
		return service.getValues(key);
	}
}
