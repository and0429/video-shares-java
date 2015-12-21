package com.coffee.share.common.spring;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

/**
 * Jaxb2 工具类
 * 
 * @author and04
 *
 */
@Named
@SuppressWarnings("unchecked")
public class JaxbUtil {

	@Inject
	private Marshaller marshaller;

	@Inject
	private Unmarshaller unmarshaller;

	/**
	 * xml文件转换成对象
	 * 
	 * @param is
	 *            输入流
	 * @param clazz
	 *            待转换的对象的类型
	 * @return 转换的对象
	 * @throws XmlMappingException
	 * @throws IOException
	 */
	public <T> T unmarshaller(InputStream is, Class<T> clazz) throws XmlMappingException, IOException {
		return (T) this.unmarshaller.unmarshal(new StreamSource(is));
	}

	/**
	 * 将java对象转换成xml字符串
	 * 
	 * @param obj
	 *            java对象
	 * @return xml格式的字符串
	 * @throws XmlMappingException
	 * @throws IOException
	 */
	public String marshaller(Object obj) throws XmlMappingException, IOException {
		
		try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
			this.marshaller.marshal(obj, new StreamResult(os));
			String xmlStr = new String(os.toByteArray()).intern();
			return xmlStr;
		}
	}

	/**
	 * 将java对象写到xml文件
	 * 
	 * @param obj
	 *            java对象
	 * @param filePath
	 *            文件路径
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void marshaller2File(Object obj, String filePath) throws FileNotFoundException, IOException {

		try (OutputStream os = new FileOutputStream(filePath)) {
			this.marshaller.marshal(obj, new StreamResult(os));
		}
	}

}
