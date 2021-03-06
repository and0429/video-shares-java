package com.coffee.share.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.share.system.dao.DataDictionaryDao;
import com.coffee.share.system.domain.DataDictionary;
import com.coffee.share.system.service.DataDictionaryService;

/**
 * 
 * @author and04
 *
 */
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Autowired
    private DataDictionaryDao dao;

    /*
     * (non-Javadoc)
     * 
     * @see com.coffee.share.system.service.DataDictionaryService#save(com.coffee.
     * share.system.domain.DataDictionary)
     */
    @Override
    public int save(DataDictionary dd) {
        return dao.save(dd);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.coffee.share.system.service.DataDictionaryService#getValue(java.lang.
     * String)
     */
    @Override
    public List<DataDictionary> getValues(String key) {
        return dao.getValues(key);
    }

}
