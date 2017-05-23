package webmagic.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import per.cr.spider.serivce.FoodService;
import per.cr.spider.serivce.RegionService;
import per.cr.spider.serivce.ShopService;
import per.cr.spider.serivce.StreetService;

@Service
public class DubboTest {
	@Autowired
	private FoodService foodService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private StreetService streetService;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
		DubboTest dubboTest = (DubboTest) ac.getBean("dubboTest");
		dubboTest.test();
	}

	public void test() {
		System.out.println("结果" + shopService.toString());
		System.out.println(streetService.hashCode());
		System.out.println(regionService.hashCode());
		System.out.println(foodService.hashCode());
	}
}
