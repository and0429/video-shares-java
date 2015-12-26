package com.coffee.share.system.dao;

import java.util.List;

import com.coffee.share.system.domain.DataDictionary;

/**
 * 
 * @author and04
 *
 */
public interface DataDictionaryDao {

	/**
	 * save
	 * 
	 * @param dd
	 * @return
	 */
	int save(DataDictionary dd);

	/**
	 * get value by key
	 * 
	 * @param key
	 * @return
	 */
	List<DataDictionary> getValues(String key);
}
