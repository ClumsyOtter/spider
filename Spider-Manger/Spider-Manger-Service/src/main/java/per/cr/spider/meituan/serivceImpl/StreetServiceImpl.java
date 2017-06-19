package per.cr.spider.meituan.serivceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.cr.spider.meituan.dao.StreetMapper;
import per.cr.spider.meituan.pojo.Street;
import per.cr.spider.meituan.pojo.StreetExample;
import per.cr.spider.meituan.serivce.StreetService;

@Service
public class StreetServiceImpl implements StreetService {
	@Autowired
	private StreetMapper streetMapper;

	/**
	 * 通过街区的名称查找街区ID 如果街区不存在则返回-1
	 * 
	 * @param name
	 * @return
	 */
	// @Override
	// public int getStreetId(String name) {
	// StreetExample example = new StreetExample();
	// per.cr.spider.pojo.StreetExample.Criteria criteria =
	// example.createCriteria();
	// criteria.andStnameEqualTo(name);
	// List<Street> selectByExample = streetMapper.selectByExample(example);
	// if (selectByExample == null || selectByExample.isEmpty()) {
	// return -1;
	// }
	// return selectByExample.get(0).getStid();
	// }

	/**
	 * 如果street存在则返回 不存在则创建
	 * 
	 * @param name
	 * @param fid
	 * @return
	 */
	@Override
	public int getStreetIds(String name, int fid) {
		StreetExample example = new StreetExample();
		per.cr.spider.meituan.pojo.StreetExample.Criteria criteria = example.createCriteria();
		criteria.andStnameEqualTo(name);
		List<Street> selectByExample = streetMapper.selectByExample(example);
		if (selectByExample == null || selectByExample.isEmpty()) {
			Street street = new Street();
			street.setStfaid(fid);
			street.setStname(name);
			streetMapper.insert(street);
			return streetMapper.selectByExample(example).get(0).getStid();
		}
		return selectByExample.get(0).getStid();
	}

}
