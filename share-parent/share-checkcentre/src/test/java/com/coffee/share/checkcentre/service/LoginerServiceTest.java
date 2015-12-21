package com.coffee.share.checkcentre.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coffee.share.checkcentre.domain.LoginerUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans-common.xml", "classpath:beans.xml" })
public class LoginerServiceTest {

	@Inject
	private LoginerUserService service;

	@Test
	public void testGetByUsername() {
		LoginerUser loginer = service.getByUsername("admin");
		assertNotNull(loginer);
		assertEquals("admin", loginer.getUsername());
	}

}
