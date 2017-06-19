package per.cr.douban.control;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import per.cr.spider.douban.service.MovieService;

@Controller
public class MovieControl {
	@Autowired
	private MovieService movieService;

	@RequestMapping("/page/list.action")
	@ResponseBody()
	public String pageById(String page, String rows) {
		return movieService.page(page, rows);
	}

	@RequestMapping("/page/ratesort.action")
	@ResponseBody
	public String ratesort(String param) {
		@SuppressWarnings("unchecked")
		HashMap<String, String> map = JSON.parseObject(param, HashMap.class);
		String sort = movieService.pageByRateSort(map.get("page"), map.get("rows"), map.get("colum"), map.get("sort"));
		return sort;
	}

	@RequestMapping("/search.action")
	@ResponseBody
	public String search(String page, String rows, String colum, String data) {
		try {
			data = new String(data.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return movieService.search(page, rows, colum, data);
	}

	@RequestMapping("/chart.action")
	@ResponseBody
	public String chart(String type) {
		return movieService.moiveChart(type);
	}
}
