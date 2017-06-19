package per.cr.spider.meituan.serivceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.cr.spider.meituan.dao.FoodMapper;
import per.cr.spider.meituan.pojo.Food;
import per.cr.spider.meituan.serivce.FoodService;
@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodMapper foodMapper;

	@Override
	public void addSpiderFood(Food food) {
		foodMapper.insert(food);
	}

	@Override
	public void insert(Food food) {
		foodMapper.insert(food);

	}

}