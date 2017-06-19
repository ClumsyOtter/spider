package webmagic.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import per.cr.spider.douban.pojo.Movie;

public class JsonTEst {
	@Test
	public void json() {
		List<Movie> lists = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Movie movie = new Movie();
			movie.setMid(i);
			movie.setMname("name" + i);
			movie.setMinfo("info" + i);
			lists.add(movie);
		}
		String jsonString = JSON.toJSONString(lists);
		System.out.println(jsonString);
	}
}
