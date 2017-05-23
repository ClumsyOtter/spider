package per.cr.spider;

import java.io.IOException;
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

import per.cr.spider.service.SpiderService;
import per.cr.spider.tools.SpiderTools;

public class Spider implements Runnable {
	Logger logger = Logger.getLogger(Spider.class);

	@Override
	public void run() {
		try {
			spiderShopMsgMain();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public void spiderShopMsgMain() throws Exception {
		// 获取bean
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
		SpiderService spiderService = (SpiderService) ac.getBean("spiderService");
		// 读取抓取列表
		List<String> urls = SpiderIO.load();
		logger.info("启动爬虫");
		List<Document> spider = null;
		try {
			// 根据每次爬得页面数量计算需要爬多少次
			while (!SpiderUtils.isend(urls)) {
				// 读取保存点
				String propertiseValue = SpiderTools.getPropertiseValue("point");
				// 读取点
				int point = Integer.parseInt(propertiseValue);
				int temp = point;
				// 抓取页面
				spider = SpiderUtils.spiders(urls);
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
}
