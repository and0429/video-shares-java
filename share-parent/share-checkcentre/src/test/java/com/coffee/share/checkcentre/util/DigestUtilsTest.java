package com.coffee.share.checkcentre.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.coffee.share.common.utils.DigestUtils;

public class DigestUtilsTest {

	@Test
	public void testMd5AsHex() {
		assertEquals("202cb962ac59075b964b07152d234b70", DigestUtils.md5AsHex("123"));
	}

}
