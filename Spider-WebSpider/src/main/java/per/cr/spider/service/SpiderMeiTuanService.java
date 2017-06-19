package per.cr.spider.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.cr.spider.meituan.pojo.Food;
import per.cr.spider.meituan.pojo.Shop;
import per.cr.spider.meituan.serivce.FoodService;
import per.cr.spider.meituan.serivce.RegionService;
import per.cr.spider.meituan.serivce.ShopService;
import per.cr.spider.meituan.serivce.StreetService;

@Service
public class SpiderMeiTuanService {
	@Autowired
	private FoodService foodService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private StreetService streetService;
	static Logger logger = Logger.getLogger(SpiderMeiTuanService.class);

	public void StoreShopMsgDB(Document doc, String url) throws IOException, Exception {
		// 抓取商店信息
		String SNAME = doc.select("div.fs-section__left .title").html();
		String SADDRESS = doc.select("div.fs-section__left .geo").html();
		String SPHONE = doc.select("div.fs-section__left  p.under-title:last-child").html();
		String SGRADE = doc.select(".biz-level strong").html();
		String STYPE = doc.select(".component-bread-nav a:nth-of-type(3)").html();
		String SREGION = doc.select(".component-bread-nav a:nth-of-type(4)").html();
		String SRODE = doc.select(".component-bread-nav a:nth-of-type(5) ").html();
		// 该商店未存在
		if (shopService.getShopId(SNAME) == -1) {
			Shop shop = new Shop();
			// 名称
			if (SNAME != null) {
				SNAME = SNAME.split("\n")[0];
			}
			shop.setSname(SNAME);
			// 地址
			shop.setSaddress(SADDRESS);
			if (SGRADE == null || SGRADE.isEmpty())
				SGRADE = "-1";
			else {
				String[] split = SGRADE.split("\n");
				SGRADE = split[split.length - 1];
			}
			// 等级
			shop.setSgrade(Double.parseDouble(SGRADE));
			// 链接
			shop.setSlink(url);
			// 电话号码
			if (SPHONE != null) {
				SPHONE = SPHONE.split("\n")[0];
			}
			shop.setSphone(SPHONE);
			// 地区
			if (SREGION == null)
				SREGION = "";
			int regionId = regionService.getRegionId(SREGION);
			shop.setSregion(regionId);
			// 街区
			if (SRODE == null)
				SRODE = "";
			shop.setSrode(streetService.getStreetIds(SRODE, regionId));
			// 类型
			shop.setStype(STYPE);
			// 插入
			shopService.insert(shop);
			// 抓取食物信息
			List<Food> list = new ArrayList<>();
			String FNAMES = doc.select("div#anchor-salelist li .title").html();
			String[] names = FNAMES.split("\n");
			String FPRICES = doc.select("div#anchor-salelist li .price strong").html();
			String[] prices = FPRICES.split("\n");
			String FSALE = doc.select("div#anchor-salelist li .sale").html();
			String[] sale = FSALE.split("\n");
			String FDATE = doc.select("div#anchor-salelist li .item__duedate span").html();
			String[] date = FDATE.split("\n");
			// 存储食品信息
			for (int i = 0; i < names.length; i++) {
				Food food = new Food();
				// 时间
				Date date2 = null;
				try {
					String substring = date[i].substring(4).replaceAll("\\.", "-");
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					date2 = simpleDateFormat.parse(substring);
				} catch (Exception e) {
					logger.error("时间错误");
				}
				food.setFdate(date2);
				// 名称
				food.setFname(names[i]);
				// 所属店铺
				food.setFsid(shopService.getShopId(SNAME));
				// 价格
				food.setFprice(Double.parseDouble(prices[i]));
				// 销售数量
				int sales = Integer.parseInt(sale[i].substring(2));
				food.setFsale(sales);
				// 存储
				list.add(food);
			}
			// 食品链接的处理
			Elements select = doc.select("div#anchor-salelist li.item");
			int count = 0;
			for (Element element : select) {
				Elements elementsByTag = element.getElementsByTag("a");
				String attr = null;
				for (Element element2 : elementsByTag) {
					attr = element2.attr("href");
				}
				if (count < list.size()) {
					list.get(count).setFlink(attr);
					// 存储
					foodService.insert(list.get(count));
					count++;
				}
			}
		}
	}
}
