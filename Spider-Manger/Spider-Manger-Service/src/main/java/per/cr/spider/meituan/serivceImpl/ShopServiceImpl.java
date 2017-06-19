package per.cr.spider.meituan.serivceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.cr.spider.meituan.dao.ShopMapper;
import per.cr.spider.meituan.pojo.Shop;
import per.cr.spider.meituan.pojo.ShopExample;
import per.cr.spider.meituan.serivce.ShopService;
@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopMapper shopMapper;

	/**
	 * 通过店名查询店的id 不存在返回-1
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public int getShopId(String name) {
		ShopExample example = new ShopExample();
		per.cr.spider.meituan.pojo.ShopExample.Criteria criteria = example.createCriteria();
		criteria.andSnameEqualTo(name);
		List<Shop> selectByExample = shopMapper.selectByExample(example);
		if (selectByExample == null || selectByExample.isEmpty()) {
			return -1;
		}
		return selectByExample.get(0).getSid();
	}

	@Override
	public void insert(Shop shop) {
		shopMapper.insert(shop);
	}

}
