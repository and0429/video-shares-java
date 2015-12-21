package com.coffee.share.common.spring;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.oxm.XmlMappingException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coffee.share.common.domain.ClientSystem;
import com.coffee.share.common.domain.ClientSystemList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans-common.xml"})
public class JaxbUtilTest {
	
	@Inject
	private JaxbUtil util;
	
	@Test
	public void testUnmarshaller() throws XmlMappingException, IOException {
		InputStream is = ResourceUtil.getResourceAsStream("classpath:client_system.xml");
		ClientSystemList csl = util.unmarshaller(is, ClientSystemList.class);
		List<ClientSystem> cs = csl.getSystems();
		assertEquals("oa", cs.get(0).getId());
		assertEquals("crm", cs.get(1).getId());
		assertEquals("/index.jsp", cs.get(1).getHomeUri());
	}

}
