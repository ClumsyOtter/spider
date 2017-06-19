package per.cr.spider.meituan.serivce;

import per.cr.spider.meituan.pojo.Shop;

public interface ShopService {
	int getShopId(String name);

	void insert(Shop shop);
}
