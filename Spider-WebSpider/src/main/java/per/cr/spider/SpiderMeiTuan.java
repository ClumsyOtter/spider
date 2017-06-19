package per.cr.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import per.cr.spider.IO.SpiderIO;

import per.cr.spider.service.SpiderMeiTuanService;
import per.cr.spider.tools.SpiderTools;
import per.cr.spider.util.SpiderUtils;

public class SpiderMeiTuan {
	static Logger logger = Logger.getLogger(SpiderMeiTuan.class);

	@SuppressWarnings("resource")
	public void spiderShopMsgMain() throws Exception {
		// 获取bean
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
		SpiderMeiTuanService spiderService = (SpiderMeiTuanService) ac.getBean("spiderService");
		// 读取抓取列表
		List<String> urls = SpiderIO.load();
		logger.info("启动爬虫");
		List<Document> spider = null;
		try {
			// 根据每次爬得页面数量计算需要爬多少次
			while (!isend(urls)) {
				// 读取保存点
				String propertiseValue = SpiderTools.getPropertiseValue("point");
				// 读取点
				int point = Integer.parseInt(propertiseValue);
				int temp = point;
				// 抓取页面
				spider = spiders(urls);
				for (Document document : spider) {
					spiderService.StoreShopMsgDB(document, urls.get(temp++));
					SpiderTools.setPropertiseValue("point", (++point) + "");
					logger.info("存储成功  保存点更新为" + (point));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("存储错误");
		}
	}

	@Test
	public void spiderShopLink() throws IOException {
		// 获取访问页数
		String value = SpiderTools.getPropertiseValue("page");
		int page = Integer.parseInt(value);
		for (int i = page; i < page + 10; i++) {
			logger.info("访问page" + i);
			Document docProxy = SpiderUtils.getDocProxy("http://nc.meituan.com/category/meishi/all/page" + i);
			String html = docProxy.html();
			Document doc = Jsoup.parse(html);
			String attr = doc.select("div.J-scrollloader").attr("data-async-params");
			Pattern pattern = Pattern.compile("\\[[\\d,]+\\]");
			Matcher matcher = pattern.matcher(attr);
			while (matcher.find()) {
				String group = matcher.group();
				String[] strings = group.substring(1, group.length() - 1).split(",");
				String path = SpiderTools.getPropertiseValue("path");
				SpiderIO.save(path, strings, "http://nc.meituan.com/shop/", "\n");
			}
			// 页面成功访问 更新page
			SpiderTools.setPropertiseValue("page", i + "");
		}
	}

	/**
	 * 根据配置文件中的point属性来确定起点 point是爬取过程中失败的存储点
	 * 
	 * @param urls
	 * @param regex
	 * @return
	 * @throws Exception
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static List<Document> spiders(List<String> urls) throws Exception {
		List<Document> filter = new ArrayList<>();
		try {
			String propertiseValue = SpiderTools.getPropertiseValue("point");
			String sizes = SpiderTools.getPropertiseValue("size");
			// 读取点
			int point = Integer.parseInt(propertiseValue);
			int temp = point;
			// 读取长度
			int size = Integer.parseInt(sizes);
			// point + size是否超出范围
			if ((point + size) >= urls.size())
				// 超出就修改size大小
				size = urls.size() - point - 1;
			// 抓取指定数量页面
			for (int i = point; i < temp + size; i++) {
				String url = urls.get(i);
				// 连接
				logger.info("-----连接  --> " + url);
				// 下载
				Document document = SpiderUtils.getDocProxy(url);
				filter.add(document);
				point++;
				// 抓取间隔
				logger.info("等待" + i);
				SpiderUtils.RadomWaitTime();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("网络中断");
			throw new Exception();
		}
		return filter;
	}

	// 是否将url访问完毕
	public static boolean isend(List<String> urls) throws IOException {
		String propertiseValue = SpiderTools.getPropertiseValue("point");
		int point = Integer.parseInt(propertiseValue);
		if (point >= urls.size())
			return true;
		return false;
	}
}
