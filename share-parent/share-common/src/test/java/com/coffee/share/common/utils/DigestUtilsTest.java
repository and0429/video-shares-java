package com.coffee.share.common.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class DigestUtilsTest {

	@Test
	public void test() {
		String code = DigestUtils.base64AsHex("12333333332e32e32ewqe2ewqewq".getBytes());
		assertEquals("MTIzMzMzMzMzMzJlMzJlMzJld3FlMmV3cWV3cQ==", code);
	}

}
