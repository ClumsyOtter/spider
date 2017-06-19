package per.cr.spider;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import per.cr.spider.service.SpiderDoubanSerice;
import per.cr.spider.tools.SpiderTools;
import per.cr.spider.util.SpiderUtils;

public class SpiderTouBan {
	static Logger logger = Logger.getLogger(SpiderTouBan.class);
	static String date[] = { "2016", "2015", "2013", "2014", "2011", "2012", "2010", "2009", "2008", "2007", "2006",
			"2004", "2005", "2003", "2001", "2002", "1994", "1997", "2000", "1999", "1998", "1995", "1996", "1993",
			"1992", "1990", "1991", "1988" };

	@SuppressWarnings("resource")
	public void spiderStart() throws IOException, InterruptedException {
		// 获取bean
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
		SpiderDoubanSerice spiderService = (SpiderDoubanSerice) ac.getBean("spiderDoubanSerice");
		// 获取年份
		String str = SpiderTools.getPropertiseValue("date");
		int dates = Integer.parseInt(str);
		logger.info("初始年份" + date[dates]);
		// 循环抓取
		for (int j = dates; j < date.length; j++) {
			Document doc = SpiderUtils.getDoc("https://movie.douban.com/tag/" + date[j]);
			int pageSize = spiderService.getPageSize(doc);
			String page = SpiderTools.getPropertiseValue("page");
			int pages = Integer.parseInt(page);
			if (pages >= pageSize) {
				logger.info("抓取" + date[j + 1]);
				SpiderTools.setPropertiseValue("page", "1");
				SpiderTools.setPropertiseValue("date", (j + 1) + "");
				continue;
			}
			logger.info("初始页数--" + page);
			for (int i = pages; i <= pageSize; i++) {
				logger.info("等待访问页面--" + i);
				SpiderUtils.RadomWaitTime();
				Document document = SpiderUtils
						.getDoc("https://movie.douban.com/tag/" + date[j] + "?start=" + (i - 1) * 20 + "&amp;type=T");
				spiderService.store(document);
				SpiderTools.setPropertiseValue("page", (i + 1) + "");
				logger.info("存储成功--记录点为--" + (i + 1));
			}
			logger.info("抓取" + date[j + 1]);
			SpiderTools.setPropertiseValue("page", "1");
			SpiderTools.setPropertiseValue("date", (j + 1) + "");
		}
	}
}
