package com.coffee.share.checkcentre.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coffee.share.common.spring.JaxbUtil;
import com.coffee.share.common.spring.ResourceUtil;
import com.coffee.share.common.spring.SpringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class LoginerServiceTest {

    
    @Autowired
    private SpringUtil su;
 
    @Test
    public void test() {
        
        ResourceUtil ru = su.getBean(ResourceUtil.class);
        JaxbUtil b =  su.getBean(JaxbUtil.class);
        
        
    }
    
    
    
    

}
