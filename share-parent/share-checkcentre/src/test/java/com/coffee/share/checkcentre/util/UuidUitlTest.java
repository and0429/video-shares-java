package com.coffee.share.checkcentre.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.coffee.share.common.utils.UuidUitl;

public class UuidUitlTest {

	@Test
	public void testUuid() {
		String s = UuidUitl.uuid();
		assertEquals(32, s.length());
	}
}
