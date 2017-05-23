package per.cr.spider.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import per.cr.spider.tools.SpiderTools;

/** 将数据存入文件 */

public class SpiderIO {
	private static Logger logger = Logger.getLogger(SpiderIO.class);

	public static void save(String path, List<String> list, String head, String end) {
		try {
			// 数据是否为空
			if (list == null || list.size() <= 0) {
				logger.warn("数据为空");
				return;
			}
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path), true));
			for (String string : list) {
				bufferedWriter.write(head + string + end);
			}
			logger.info("保存成功");
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("保存失败");
		}
	}

	public static void save(List<String> list) throws IOException {
		String path = SpiderTools.getPropertiseValue("path");
		save(path, list, null, null);
	}

	/**
	 * 存数据
	 * 
	 * @return
	 * @throws Exception
	 */

	public static void save(String path, String[] list, String head, String end) {
		try {
			// 数据是否为空
			if (list == null || list.length <= 0) {
				logger.warn("数据为空");
				return;
			}
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path), true));
			for (String string : list) {
				bufferedWriter.write(head + string + end);
			}
			logger.info("保存成功");
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("保存失败");
		}
	}

	/*
	 * 读出文件
	 */
	public static List<String> load() throws Exception {
		ArrayList<String> arrayList = new ArrayList<>();
		// 从配置文件获取
		Properties properties = new Properties();
		properties.load(new FileReader(new File(
				"F:/JavaCode/JavaResource/Spider-Parent/Spider-WebSpider/src/main/resources/properties/savepoint.properties")));
		String property = properties.getProperty("path");
		File file = new File(property);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		// 全部读取
		while (bufferedReader.ready())
			arrayList.add(bufferedReader.readLine());
		bufferedReader.close();
		return arrayList;
	}

}
