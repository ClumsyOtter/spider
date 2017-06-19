package per.cr.spider.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.cr.spider.douban.pojo.Movie;
import per.cr.spider.douban.service.MovieService;

@Service
public class SpiderDoubanSerice {
	@Autowired
	private MovieService movieService;

	public void store(Document doc) {
		Elements elements = doc.select(".item a.nbg");
		List<Movie> movies = new ArrayList<Movie>();
		for (int i = 0; i < elements.size(); i++) {
			Movie movie = new Movie();
			// 链接
			String href = elements.get(i).attr("href");
			if (href != null)
				movie.setSlink(href);
			// 名称
			String title = elements.get(i).attr("title");
			if (title != null)
				movie.setMname(title);
			movies.add(movie);
		}
		String date = doc.select(".tags-name").html();
		// 信息
		String msg = doc.select("div.pl2 p.pl").html();
		String[] msgs = msg.split("\n");
		// 评分 评价人数
		String ratepl = doc.select(".star span").html();
		String[] plrates = ratepl.split("\n\n");
		// 创建movie对象 并设置信息
		for (int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			if (date != null) {
				try {
					movie.setMdate(Integer.parseInt(date));
				} catch (Exception e) {
					System.out.println("年份错误");
				}
			}
			if (i < msgs.length && msgs[i] != null)
				movie.setMinfo(msgs[i]);
			// 评分以及评价
			if (i < plrates.length && plrates[i] != null) {
				if (plrates[i].equals("(评价人数不足)") || plrates[i].equals("(目前无人评价)")) {
					movie.setMrate(-1.0);
					movie.setMpls(0);
				} else if (plrates[i].equals("(尚未上映)")) {
					movie.setMrate(-2.0);
					movie.setMpls(0);
				} else {
					String[] split = plrates[i].split("\n");
					// 评分
					try {
						movie.setMrate(Double.parseDouble(split[0]));
						// 评论人数
						if (split[1] != null) {
							Pattern pattern = Pattern.compile("\\d+");
							Matcher matcher = pattern.matcher(split[1]);
							while (matcher.find()) {
								movie.setMpls(Integer.parseInt(matcher.group()));
							}
						}
					} catch (Exception e) {
						System.out.println("错误");
					}
				}
			}
		}
		// 存入数据库
		Iterator<Movie> iterators = movies.iterator();
		while (iterators.hasNext()) {
			movieService.add(iterators.next());
		}
	}

	public int getPageSize(Document doc) {
		String html = doc.select(".paginator a").html();
		String[] split = html.split("\n");
		String string = split[split.length - 2];
		return Integer.parseInt(string);
	}
}
