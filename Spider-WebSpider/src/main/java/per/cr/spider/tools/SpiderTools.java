package per.cr.spider.tools;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class SpiderTools {
	/**
	 * 获取配置文件的值
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String getPropertiseValue(String key) throws IOException {
		Properties properties = new Properties();
		properties.load(new FileReader(new File(
				"F:/JavaCode/JavaResource/Spider-Parent/Spider-WebSpider/src/main/resources/properties/savepoint.properties")));
		return properties.getProperty(key);
	}

	/*
	 * 设置配置文件的值
	 */
	public static void setPropertiseValue(String key, String value) throws IOException {
		Properties properties = new Properties();
		properties.load(new FileReader(new File(
				"F:/JavaCode/JavaResource/Spider-Parent/Spider-WebSpider/src/main/resources/properties/savepoint.properties")));
		properties.setProperty(key, value);
		properties.store(
				new FileWriter(new File(
						"F:/JavaCode/JavaResource/Spider-Parent/Spider-WebSpider/src/main/resources/properties/savepoint.properties")),
				null);
	}

}
