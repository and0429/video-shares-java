package com.coffee.share.system.service;

import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coffee.share.system.domain.DataDictionary;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class DataDictionaryServiceTest {

	@Inject
	private DataDictionaryService service;

	@Test
	public void testSave() {

	}

	@Test
	public void testGetValues() {
		List<DataDictionary> list = service.getValues("123");
		if (list == null) {
			return;
		}
		for (DataDictionary dataDictionary : list) {
			assertEquals("123", dataDictionary.getKey());
		}
	}

}
