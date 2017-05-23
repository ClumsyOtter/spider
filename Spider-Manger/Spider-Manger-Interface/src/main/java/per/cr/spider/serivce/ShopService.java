package per.cr.spider.serivce;

import per.cr.spider.pojo.Shop;

public interface ShopService {
	int getShopId(String name);

	void insert(Shop shop);
}
