package per.cr.spider.meituan.serivceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.cr.spider.meituan.dao.RegoinMapper;
import per.cr.spider.meituan.pojo.Regoin;
import per.cr.spider.meituan.pojo.RegoinExample;
import per.cr.spider.meituan.pojo.RegoinExample.Criteria;
import per.cr.spider.meituan.serivce.RegionService;

@Service
public class RegionServiceImpl implements RegionService {
	@Autowired
	private RegoinMapper regoinMapper;

	/**
	 * 通过地区名称查找地区ID 如果地区不存在则创建
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public int getRegionId(String name) {
		RegoinExample example = new RegoinExample();
		Criteria criteria = example.createCriteria();
		criteria.andSnameEqualTo(name);
		List<Regoin> selectByExample = regoinMapper.selectByExample(example);
		if (selectByExample == null || selectByExample.isEmpty()) {
			Regoin record = new Regoin();
			record.setSname(name);
			regoinMapper.insert(record);
			return regoinMapper.selectByExample(example).get(0).getRid();
		}
		return selectByExample.get(0).getRid();
	}

}
