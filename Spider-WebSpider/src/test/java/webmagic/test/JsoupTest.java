package webmagic.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import per.cr.spider.IO.SpiderIO;
import per.cr.spider.pojo.Food;
import per.cr.spider.pojo.Shop;
import per.cr.spider.serivce.FoodService;
import per.cr.spider.serivce.RegionService;
import per.cr.spider.serivce.ShopService;
import per.cr.spider.serivce.StreetService;
import per.cr.spider.tools.SpiderTools;

@Service
public class JsoupTest {
	@Autowired
	private FoodService foodService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private StreetService streetService;

	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
		JsoupTest jsoupTest = (JsoupTest) ac.getBean("jsoupTest");
		jsoupTest.get();
		System.out.println("---------------good--------------");
	}

	public void test() {
		System.out.println("结果" + shopService.toString());
		System.out.println(streetService.hashCode());
		System.out.println(regionService.hashCode());
		System.out.println(foodService.hashCode());
	}

	@Test
	public void get() throws IOException, Exception {
		File file = new File("F:/spider/shopMsg.txt");
		Document doc = Jsoup.parse(file, "gbk");
		String html = doc.select(".isonline").html();
		String[] split = html.split("\n");
		System.out.println(split.length * 500 / 30 / 10 / 60);
	}
}
