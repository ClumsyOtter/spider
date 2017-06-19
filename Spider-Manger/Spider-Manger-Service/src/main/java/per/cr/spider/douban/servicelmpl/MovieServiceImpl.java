package per.cr.spider.douban.servicelmpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import per.cr.spider.douban.dao.MovieMapper;
import per.cr.spider.douban.pojo.Movie;
import per.cr.spider.douban.pojo.MovieExample;
import per.cr.spider.douban.pojo.MovieExample.Criteria;
import per.cr.spider.douban.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieMapper movieMapper;

	@Override
	public void add(Movie movie) {
		movieMapper.insert(movie);
	}

	@Override
	public List<Movie> pageById(int start, int end) {
		MovieExample example = new MovieExample();
		Criteria criteria = example.createCriteria();
		criteria.andMidBetween(start, end);
		return movieMapper.selectByExample(example);
	}

	@Override
	public Movie getMovieById(int id) {
		return movieMapper.selectByPrimaryKey(id);
	}

	@Override
	public String page(String page, String rows) {
		int pages = Integer.parseInt(page);
		int row = Integer.parseInt(rows);
		int start = (pages - 1) * row;
		List<Movie> list = movieMapper.page(start, row);
		if (list != null) {
			info(list);
		}
		int count = movieMapper.count();
		Map<String, Object> map = new HashMap<>();
		map.put("total", count / row);
		map.put("rows", list);
		return JSON.toJSONString(map);
	}

	@Override
	public String pageByRateSort(String page, String rows, String colum, String sort) {
		int pagei = Integer.parseInt(page);
		int rowsi = Integer.parseInt(rows);
		int sorti = Integer.parseInt(sort);
		int start = (pagei - 1) * rowsi;
		List<Movie> lists = null;
		if (sorti == 1) {
			lists = movieMapper.pageBySort(start, rowsi, colum, "asc");
		} else {
			lists = movieMapper.pageBySort(start, rowsi, colum, "desc");
		}
		if (lists != null) {
			info(lists);
		}
		int count = movieMapper.count();
		Map<String, Object> map = new HashMap<>();
		map.put("total", count);
		map.put("rows", lists);
		return JSON.toJSONString(map);
	}

	public void info(List<Movie> list) {
		for (Movie movie : list) {
			if (movie.getMinfo().length() > 120)
				movie.setMinfo(movie.getMinfo().substring(0, 120) + "...");
		}
	}

	@Override
	public String search(String page, String rows, String colum, String data) {
		int pagei = Integer.parseInt(page);
		int rowsi = Integer.parseInt(rows);
		data = "'%" + data + "%'";
		int start = (pagei - 1) * rowsi;
		List<Movie> lists = movieMapper.search(start, rowsi, colum, data);
		int count = movieMapper.countByParam(colum, data);
		Map<String, Object> map = new HashMap<>();
		map.put("total", count);
		map.put("rows", lists);
		return JSON.toJSONString(map);
	}

	@Override
	public String moiveChart(String type) {
		switch (type) {
		case "0":
			return chart0();
		case "1":
			return chart1();
		default:
			break;
		}
		return "";
	}

	private String chart1() {
		List<Integer> years = new ArrayList<>();
		int[][] data = new int[6][27];
		for (double j = 9; j > 0; j--) {
			for (int i = 1990; i <= 2016; i++) {
				MovieExample movieExample = new MovieExample();
				Criteria criteria = movieExample.createCriteria();
				criteria.andMdateEqualTo(i);
				if (j == 5) {
					criteria.andMrateBetween(4.0, 6.0);
				} else if (j == 4) {
					criteria.andMrateBetween(0.1, 4.0);
				} else
					criteria.andMrateBetween(j, j + 1);
				int count = movieMapper.countByExample(movieExample);
				data[(int) (9.0 - j)][i - 1990] = count;
				if (j == 9) {
					years.add(i);
				}
			}
			if (j == 4)
				break;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("x", years);
		for (int m = 0; m < 6; m++) {
			map.put("y" + m, data[m]);
		}
		return JSON.toJSONString(map);
	}

	private String chart0() {
		Map<String, Object> map = new HashMap<>();
		List<Integer> years = new ArrayList<Integer>();
		List<Integer> counts = new ArrayList<Integer>();
		for (int i = 1988; i <= 2016; i++) {
			MovieExample movieExample = new MovieExample();
			Criteria criteria = movieExample.createCriteria();
			criteria.andMdateEqualTo(i);
			if (i == 1989) {
				continue;
			}
			int count = movieMapper.countByExample(movieExample);
			years.add(i);
			counts.add(count);
		}
		map.put("x", years);
		map.put("y", counts);
		return JSON.toJSONString(map);
	}

}
